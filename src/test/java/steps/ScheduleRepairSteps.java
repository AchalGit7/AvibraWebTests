package steps;

import constants.HylaLoricaURL;
import pages.ScheduleRepairPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import utils.DateUtils;

public class ScheduleRepairSteps extends ScenarioSteps implements HylaLoricaURL {

    ScheduleRepairPage scheduleRepairPage;

    @Step
    public void navigateToAvibra1LoginScreen() {
        String url = HYLA_AVIBRA1_URL.trim();
        getDriver().manage().window().maximize();
        getDriver().get(url);
    }

    @Step
    public void loginWithValidCredentials(){
        scheduleRepairPage.enterEmail();
        scheduleRepairPage.enterPassword();
        scheduleRepairPage.clickSignInButton();
    }

    @Step
    public void clickOnScheduleRepairBtn(){
        scheduleRepairPage.clickScheduleRepairButton();
    }

    @Step
    public void selectIssueFromDropDown(String issue){
        scheduleRepairPage.selectIssueRadioBtn(issue);
    }

    @Step
    public void selectIssueDate(){
        String incidentDate = DateUtils.getDate("MM/dd/yyyy",-1);
        System.out.println("Incident Date : "+incidentDate);
        scheduleRepairPage.enterIssueDate(incidentDate);
    }

    @Step
    public void enterIssueDescription(){
        scheduleRepairPage.enterIssueDesc();
    }

    @Step
    public void clickNextButton(){
        scheduleRepairPage.clickNextButton();
    }

    @Step
    public void clickEmailRadioBtn(){
        scheduleRepairPage.clickEmailRadioButton();
    }

    @Step
    public void enterAddress(String Address){
        scheduleRepairPage.enterAddress1Field(Address);
    }

    @Step
    public void enterCity(String city){
        scheduleRepairPage.enterCityField(city);
    }

    @Step
    public void enterZipCodeField(String zipCode){
        scheduleRepairPage.enterZipCode(zipCode);
    }

    @Step
    public void enterLocalDesc(){
        scheduleRepairPage.enterLocationDesc();
    }

    @Step
    public void selectStateFromDropdown(){
        scheduleRepairPage.selectState();
    }

    @Step
    public void enterAltPhoneNumber(){
        scheduleRepairPage.enterAltNumber();
    }

    @Step
    public void selectTimeToScheduleRepair(String scheduleTimeSlot){
        scheduleRepairPage.selectScheduleTimeSlot(scheduleTimeSlot);
    }

    @Step
    public void clickOnConfirmPayBtn(){
        scheduleRepairPage.clickConfirmPayButton();
    }

    @Step
    public void enterDetailsOfVisacard(String nameOnCard, String cardNumber, String address, String zipCode){
        scheduleRepairPage.enterCardNameVisaField(nameOnCard);
        scheduleRepairPage.enterCardNumberVisaField(cardNumber);
        scheduleRepairPage.selectExpMonthField();
        scheduleRepairPage.selectExpYearField();
        scheduleRepairPage.enterSecurityCodeField();
        scheduleRepairPage.enterBillingAddressField(address);
        scheduleRepairPage.enterBillingZipField(zipCode);
        scheduleRepairPage.clickContinueBtn();
        scheduleRepairPage.clickSavePaymentBtn();
    }

    @Step
    public void verifyAllSetText(){
        String allSetHeaderText = scheduleRepairPage.displayScheduledRepairText().getText();
        Assert.assertTrue(allSetHeaderText.equals("Visa"));
    }

    @Step
    public void cancelScheduRepair(){
        scheduleRepairPage.clickScheduleRepairCancelBtn();
        scheduleRepairPage.clickCloseRefundPopUpBtn();
    }


}


