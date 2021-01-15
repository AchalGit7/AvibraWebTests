package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.ReimbursementClaimSteps;
import steps.ScheduleRepairSteps;

public class ReimbursementClaimStepDef {

        @Steps
        ReimbursementClaimSteps reimbursementClaimSteps;
        @Steps
        ScheduleRepairSteps scheduleRepairSteps;

        /*@When("^User enters correct url and redirected to login screen$")
        public void user_redirect_to_login_screen() {
            scheduleRepairSteps.navigateToAvibra1LoginScreen();

        }*/

        @When("^User enters correct url and is able to login successfully after entering valid email and password$")
        public void user_able_to_login_successfully() {
            // List<Map<String, String>> list = credentials.asMaps(String.class, String.class);
            // loginSteps.loginWithValidCredentials(list.get(0).get("email"), list.get(0).get("password"));
            scheduleRepairSteps.navigateToAvibra1LoginScreen();
            reimbursementClaimSteps.loginWithValidCredentials();
        }

        @And("^User clicks on reimbursement claim button$")
        public void user_clicks_reimbursement_claim_button() {
            reimbursementClaimSteps.clickOnReimbClaimBtn();
        }

        @And("^User select issue (.+) radio button$")
        public void user_select_issue_from_dropdown(String issue){
            reimbursementClaimSteps.selectIssueFromDropDown(issue);
        }

        @And("^User enters incident date$")
        public void user_select_incident_date_from_calendar(){
            reimbursementClaimSteps.selectIssueDate();
        }

        @And("^User enters issue description and click on next button$")
        public void user_enter_issue_desc(){
            reimbursementClaimSteps.enterIssueDescription();
            reimbursementClaimSteps.clickNextButton();
        }

        @And("^User clicks Confirm and Pay button$")
        public void user_clicks_confirm_pay_btn(){
            reimbursementClaimSteps.clickOnConfirmPayBtn();
        }

        @And("^User enter card details like name (.+) card number (.+) expiration month year security code billing address (.+) billing zipcode (.+) and submit it$")
        public void user_enter_card_details(String nameOnCard, String cardNumber, String address, String zipCode){
            reimbursementClaimSteps.enterDetailsOfVisacard(nameOnCard, cardNumber, address, zipCode);
        }

        @And("^User successfully files the reimbursement claim$")
        public void user_schedules_the_repair_successfully(){
            reimbursementClaimSteps.verifyTextAfterFilingReimbClaim();
        }

    @And("^User successfully cancels the filed reimbursement claim after clicking on cancel button$")
    public void user_cancels_the_reimb_claim_successfully(){
        reimbursementClaimSteps.cancelReimbClaim();
    }


    }

