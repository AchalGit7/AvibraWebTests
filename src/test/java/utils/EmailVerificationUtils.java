package utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.search.SearchTerm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class EmailVerificationUtils {

    private static final Logger logger = LoggerFactory.getLogger(EmailVerificationUtils.class);

    private static final String imapHost = "imap.gmail.com";
    private static final String imapPort = "993";
    private String userName = null;
    private String password = null;

    public EmailVerificationUtils(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Set IMAP session
    private Session setIMAPSession() {
        // IMAP settings
        Properties properties = new Properties();

        // server setting
        properties.put("mail.imap.host", imapHost);
        properties.put("mail.imap.port", imapPort);

        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port", imapPort);
        return Session.getInstance(properties);
    }

    /*
     * Searches for e-mail messages containing the specified keyword in Subject
     * @param folderName (e.g. Inbox)
     * @param keyword Search with this Keyword in subject line
     * @param Date object after which emails to be searched. Null for any date
     * @param range Range of emails to be searched. -1 for all emails
     */
    public List<Message> searchEmail(String folderName, String keyword, Date aDate, int range) {
        logger.info("in Gmail search");

        List<Message> returnList = new ArrayList<>();
        Folder folder = null;
        Store store = null;

        try {
            //Connects to the store via IMAP session
            Session session = setIMAPSession();

            logger.info("Connecting to Message Store");
            store = session.getStore("imap");
            store.connect(userName, password);

            logger.info("Opening folder : " + folderName);
            folder = store.getFolder(folderName);
            folder.open(Folder.READ_ONLY);

            int endIndex = folder.getMessageCount();
            int startIndex;
            if (range != -1 && range < endIndex)
                startIndex = endIndex - range;
            else
                startIndex = 1;

            logger.info("Creating search condition: Searching message with Subject line: " + keyword
                    + ", within message range: " + startIndex + "," + endIndex + ", sent after date: " + aDate);
            SearchTerm searchCondition = getSearchTerm(keyword, null);

            logger.info("Performing search through the folder:");
            Message[] messages = folder.search(searchCondition, folder.getMessages(startIndex,endIndex));
            logger.info("Number of messages found: " + messages.length);
            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];
                // assuming 'message' is retrieved from folder object
                Message copyOfMessage = new MimeMessage((MimeMessage) message);
                returnList.add(copyOfMessage);
            }

        } catch (NoSuchProviderException ex) {
            logger.info("No provider found.\n" + ex.getMessage());
            ex.printStackTrace();

        } catch (MessagingException ex) {
            logger.info("Could not connect to the message store.\n" + ex.getMessage());
            ex.printStackTrace();

        } finally {
            logger.info("Disconnecting...");
            if (folder != null) {
                try {
                    folder.close(true);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            if (store != null) {
                try {
                    store.close();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }

        }
        return returnList;
    }

    /*
     * Create SearchTerm according to keyword and date
     */
    private SearchTerm getSearchTerm(String keyword, Date aDate) {
        return new SearchTerm() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean match(Message message) {
                try {
                    if (message.getSubject().contains(keyword)
                            && (aDate == null || message.getSentDate().after(aDate))) {
                        return true;
                    }
                } catch (MessagingException ex) {
                    logger.info(ex.getMessage());
                    ex.printStackTrace();
                }
                return false;
            }
        };
    }

    /*
     * Returns the primary text content of the email body
     * if only text content of the email is required, getTextOnly = true
     * if email content as it is send is required in html form, getTextOnly = false
     */
    public String getText(Part p, boolean getTextOnly) throws MessagingException, IOException {
        if (p.isMimeType("text/*")) {
            return (String) p.getContent();
        }

        if (p.isMimeType("multipart/alternative")) {
            Multipart mp = (Multipart) p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (getTextOnly) {
                    // prefer text over html
                    if (bp.isMimeType("text/plain")) {
                        String s = getText(bp, true);
                        if (s != null)
                            return s;
                    }
                } else {
                    // prefer html text over plain text
                    if (bp.isMimeType("text/plain")) {
                        if (text == null)
                            text = getText(bp, false);
                        continue;
                    } else if (bp.isMimeType("text/html")) {
                        String s = getText(bp, false);
                        if (s != null)
                            return s;
                    } else {
                        return getText(bp, false);
                    }
                    return text;
                }
            }
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart) p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i), getTextOnly);
                if (s != null)
                    return s;
            }
        }
        return null;
    }
}

