package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class ImeiUtils {

    private static final Logger logger = LogManager.getLogger(ImeiUtils.class);

    public static String generateImei() {

        Random myRandom = new Random();
        StringBuilder imeiNumber = new StringBuilder(14);

        imeiNumber.append("799215034");

        logger.info("\n\t*****************************\n\nValid IMEI number generator\n\n");

        for (int counter = 0; counter < 5; counter++) {
            imeiNumber.append(1 + myRandom.nextInt(8));
        }

        int generatedCheckDigit = getCheckDigit(imeiNumber.toString());

        imeiNumber = imeiNumber.append(generatedCheckDigit);

        logger.info("\n\t*****************************\n\nValid IMEI number is " + imeiNumber + "\n\n");

        return imeiNumber.toString();

    }

    private static void generateCheckDigit(String imei) {

        logger.info("IMEI check digit generator");

        if (imei.length() > 14 || imei.length() < 14) {

            logger.info("IMEI Length not 14 ,Please provide 14 digit IMEI");
        } else {

            int generatedCheckDigit = getCheckDigit(imei);

            logger.info("Check Digit " + generatedCheckDigit);

            logger.info("Complete IMEI number is " + imei + generatedCheckDigit);

        }
    }

    private static int getCheckDigit(String input) {

        int sum = 0;

        for (int counter = 13; counter >= 0; counter--) {
            String digitString = input.substring(counter, counter + 1);

            int digit = Integer.valueOf(digitString);

            if (counter % 2 == 0) {
                sum += digit;
            } else {
                sum += sumUpDigits(digit);
            }
        }

        sum *= 9;

        return sum % 10;
    }

    private static int sumUpDigits(int digit) {

        int sum = 0;
        digit *= 2;
        while (digit > 0) {

            sum += digit % 10;
            digit /= 10;
        }

        return sum;

    }

}
