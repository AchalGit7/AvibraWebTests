package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.ScheduleRepairSteps;

public class ScheduleRepairStepDef {

    @Steps
    ScheduleRepairSteps scheduleRepairSteps;


    @When("^User enters correct url and redirected to login screen$")
    public void user_redirect_to_login_screen() {
        scheduleRepairSteps.navigateToAvibra1LoginScreen();

    }

    @And("^User is able to login after entering valid email and password$")
    public void user_able_to_login_successfully() {
       // List<Map<String, String>> list = credentials.asMaps(String.class, String.class);
       // loginSteps.loginWithValidCredentials(list.get(0).get("email"), list.get(0).get("password"));
        scheduleRepairSteps.loginWithValidCredentials();
    }

    @And("^User clicks on schedule repair button$")
    public void user_clicks_schedule_repair_button() {
        scheduleRepairSteps.clickOnScheduleRepairBtn();

    }

    @And("^User select issue (.+) from dropdown$")
    public void user_select_issue_from_dropdown(String issue){
        scheduleRepairSteps.selectIssueFromDropDown(issue);
    }

    @And("^User selects incident date from the calendar$")
    public void user_select_incident_date_from_calendar(){
        scheduleRepairSteps.selectIssueDate();
    }

    @And("^User enters the issue description and click on next button$")
    public void user_enter_issue_desc(){
        scheduleRepairSteps.enterIssueDescription();
        scheduleRepairSteps.clickNextButton();
    }

    @And("^User select email radio button and click on next button$")
    public void user_select_email_radio_button(){
        scheduleRepairSteps.enterAltPhoneNumber();
        scheduleRepairSteps.clickEmailRadioBtn();
        scheduleRepairSteps.clickNextButton();
    }

    @And("^User enters details of Address like Address1 (.+) city (.+) zipcode (.+) and then clicks on next button$")
    public void user_enter_address_details(String address, String city, String zipCode){
        scheduleRepairSteps.enterAddress(address);
        scheduleRepairSteps.enterCity(city);
        scheduleRepairSteps.selectStateFromDropdown();
        scheduleRepairSteps.enterZipCodeField(zipCode);
        scheduleRepairSteps.enterLocalDesc();
        scheduleRepairSteps.clickNextButton();
    }

    @And("^User selects timeslot (.+) to schedule repair$")
    public void user_clicks_schedule_repair_button(String scheduleTimeSlot) {
        scheduleRepairSteps.selectTimeToScheduleRepair(scheduleTimeSlot);
        scheduleRepairSteps.clickNextButton();

    }

    @And("^User clicks on Confirm and Pay button$")
    public void user_clicks_confirm_pay_btn(){
        scheduleRepairSteps.clickOnConfirmPayBtn();
    }

    @And("^User enter and submit card details like name (.+) card number (.+) expiration month year security code billing address (.+) and billing zipcode(.+)$")
    public void user_enter_card_details(String nameOnCard, String cardNumber, String address, String zipCode){
        scheduleRepairSteps.enterDetailsOfVisacard(nameOnCard, cardNumber, address, zipCode);
    }

    @And("^User successfully schedules the repair and All set text is displayed$")
    public void user_schedules_the_repair_successfully(){
        scheduleRepairSteps.verifyAllSetText();
    }

    @And("^User successfully cancels the schedule repair after clicking on cancel button$")
    public void user_cancels_the_schedule_repair_successfully(){
        scheduleRepairSteps.cancelScheduRepair();
    }


}