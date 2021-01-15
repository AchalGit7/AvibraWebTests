package steps;

import constants.HylaLoricaURL;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import pages.ReimbursementClaimPage;
import utils.DateUtils;

public class ReimbursementClaimSteps extends ScenarioSteps implements HylaLoricaURL {

        ReimbursementClaimPage reimbursementClaimPage;
        

        @Step
        public void loginWithValidCredentials(){
            reimbursementClaimPage.enterEmail();
            reimbursementClaimPage.enterPassword();
            reimbursementClaimPage.clickSignInButton();
        }

        @Step
        public void clickOnReimbClaimBtn(){
            reimbursementClaimPage.clickReimburseClaimButton();
        }

        @Step
        public void selectIssueFromDropDown(String issue){
            reimbursementClaimPage.selectIssueRadioBtn(issue);
        }

        @Step
        public void selectIssueDate(){
            String incidentDate = DateUtils.getDate("MM/dd/yyyy",-1);
            System.out.println("Incident Date : "+incidentDate);
            reimbursementClaimPage.enterIssueDate(incidentDate);
        }

        @Step
        public void enterIssueDescription(){
            reimbursementClaimPage.enterIssueDesc();
        }

        @Step
        public void clickNextButton(){
            reimbursementClaimPage.clickNextButton();
        }

        @Step
        public void clickEmailRadioBtn(){
            reimbursementClaimPage.clickEmailRadioButton();
        }

        @Step
        public void enterAddress(String Address){
            reimbursementClaimPage.enterAddress1Field(Address);
        }

        @Step
        public void enterCity(String city){
            reimbursementClaimPage.enterCityField(city);
        }

        @Step
        public void enterZipCodeField(String zipCode){
            reimbursementClaimPage.enterZipCode(zipCode);
        }

        @Step
        public void enterLocalDesc(){
            reimbursementClaimPage.enterLocationDesc();
        }

        @Step
        public void selectStateFromDropdown(){
            reimbursementClaimPage.selectState();
        }

        @Step
        public void enterAltPhoneNumber(){
            reimbursementClaimPage.enterAltNumber();
        }

        @Step
        public void selectTimeToScheduleRepair(String scheduleTimeSlot){
            reimbursementClaimPage.selectScheduleTimeSlot(scheduleTimeSlot);
        }

        @Step
        public void clickOnConfirmPayBtn(){
            reimbursementClaimPage.clickConfirmPayButton();
        }

        @Step
        public void enterDetailsOfVisacard(String nameOnCard, String cardNumber, String address, String zipCode){
            reimbursementClaimPage.enterCardNameVisaField(nameOnCard);
            reimbursementClaimPage.enterCardNumberVisaField(cardNumber);
            reimbursementClaimPage.selectExpMonthField();
            reimbursementClaimPage.selectExpYearField();
            reimbursementClaimPage.enterSecurityCodeField();
            reimbursementClaimPage.enterBillingAddressField(address);
            reimbursementClaimPage.enterBillingZipField(zipCode);
            reimbursementClaimPage.clickContinueBtn();
            reimbursementClaimPage.clickSavePaymentBtn();
        }

        @Step
        public void verifyTextAfterFilingReimbClaim(){
            String reimbFileClaimText = reimbursementClaimPage.displayReimbClaimFileText().getText();
            Assert.assertTrue(reimbFileClaimText.equals("Reimbursement"));
        }

    @Step
    public void cancelReimbClaim(){
        reimbursementClaimPage.clickReimbCancelBtn();
        reimbursementClaimPage.clickCloseBtn();
    }


    }
    
