package pages;

import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import utils.PropertyUtils;
import utils.WaitUtils;


public class ScheduleRepairPage extends PageObject {



	@FindBy(id = "username")
	private WebElementFacade emailAddressField;

	@FindBy(id = "password")
	private WebElementFacade passwordField;

	@FindBy(xpath = "//*[contains(text(), 'Sign In')]")
	private WebElementFacade signInButton;

	@FindBy(xpath = "//a[contains(text(), 'Schedule a Repair')]")
	private WebElementFacade scheduleRepairButton;

	@FindBy(id = "dateOfIncident")
	private WebElementFacade calendarTextField;

	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-formControl MuiInputBase-multiline MuiOutlinedInput-multiline']/textarea")
	private WebElementFacade issueDescTextbox;

	@FindBy(xpath = "//div/button[contains(text(), 'Next')]")
	private WebElementFacade nextBtn;

	@FindBy(css = ".MuiFormControlLabel-root:nth-child(1)")
	private WebElementFacade emailRadioBtn;

	@FindBy(id = "streetAddress1")
	private WebElementFacade address1TextField;

	@FindBy(id = "city")
	private WebElementFacade cityTextField;

	@FindBy(id = "zipcode")
	private WebElementFacade zipCodeField;

	@FindBy(id = "locationDescription")
	private WebElementFacade locationDesc;

	@FindBy(xpath = "//select[@class='MuiSelect-root MuiSelect-select MuiInputBase-input MuiInput-input MuiInputBase-inputSelect']")
	private WebElementFacade stateDropDown;

	@FindBy(xpath = "//input[@placeholder='(888) 555-1234']")
	private WebElementFacade altPhoneNumber;

	@FindBy(xpath = "//button[contains(text(), 'Confirm & Pay')]")
	private WebElementFacade confirmPayBtn;

	@FindBy(id = "NameOnCard")
	private WebElementFacade nameOnVisaCardField;

	@FindBy(id = "CardNumber")
	private WebElementFacade cardNumberField;

	@FindBy(id = "ExpirationMonth")
	private WebElementFacade monthCardCalendar;

	@FindBy(id = "ExpirationYear")
	private WebElementFacade yearCardCalendar;

	@FindBy(id = "SecurityCode")
	private WebElementFacade securityCodeField;

	@FindBy(id = "BillingAddressStreet")
	private WebElementFacade billingAddressField;

	@FindBy(id = "BillingZip")
	private WebElementFacade billingZipCodeField;

	@FindBy(id = "ContinueButton")
	private WebElementFacade continueButton;

	@FindBy(id = "SubmitButton")
	private WebElementFacade submitPaymentButton;

	@FindBy(xpath = "//span[contains(text(), 'Visa')]")
	private WebElementFacade visaAfterScheduledRepairTxt;

	@FindBy(xpath = "//div/span[contains(text(), 'Available Appointments')]")
	private WebElementFacade appointmentTxt;

	@FindBy(xpath = "//button[contains(text(), 'Cancel')]")
	private WebElementFacade cancelRepairButton;

	@FindBy(xpath = "//button[text() = 'Yes']")
	private WebElementFacade cancelYesRepairButton;

	@FindBy(xpath = "//button[text() = 'Close']")
	private WebElementFacade refundPopUpCloseButton;

	public void selectIssueRadioBtn(String issue) {
		$(By.xpath("//span[contains(text(), '"+ issue +"')]")).click();
	}

	public void selectScheduleTimeSlot(String scheduleTimeSlot) {
		WaitUtils.waitForElementToAppear(getDriver(), appointmentTxt);
		$(By.xpath("//div[contains(text(), '"+ scheduleTimeSlot +"')]")).click();
	}

	public WebElementFacade getAssistanceStartQuoteText(String username) {
		return $(By.xpath("//*[@content-desc='great__hi_" + username + "_lets_get_you_started_with_your_quote']"));
	}

//	public void clickGetCoveredBtn() {
//		WaitUtils.waitForElementToAppear(getDriver(), getCoveredBtn);
//		getCoveredBtn.click();
//	}

	public void enterEmail() {
		String emailAddress = PropertyUtils.getProperty("hyla.username");
		WaitUtils.waitForElementToAppear(getDriver(), emailAddressField);
		emailAddressField.sendKeys(emailAddress);
	}

	public void enterPassword() {
		String password = PropertyUtils.getProperty("hyla.password");
		WaitUtils.waitForElementToAppear(getDriver(), passwordField);
		passwordField.sendKeys(password);
	}

	public void clickSignInButton(){
		WaitUtils.waitForElementToAppear(getDriver(), signInButton);
		signInButton.click();
	}

	public void clickScheduleRepairButton(){
		WaitUtils.waitForElementToAppear(getDriver(), scheduleRepairButton);
		scheduleRepairButton.click();
	}


	public void enterIssueDate(String incidentDate){
		WaitUtils.waitForElementToAppear(getDriver(), calendarTextField);
		calendarTextField.clear();
		calendarTextField.click();
		calendarTextField.sendKeys(incidentDate);
	}

	public void enterIssueDesc(){
		WaitUtils.waitForElementToAppear(getDriver(), issueDescTextbox);
		issueDescTextbox.sendKeys("Smoke Test");
	}

	public void clickNextButton(){
		WaitUtils.waitForElementToAppear(getDriver(), nextBtn);
		nextBtn.click();
	}

	public void clickEmailRadioButton(){
		emailRadioBtn.waitUntilClickable();
		emailRadioBtn.click();
	}

	public void enterAddress1Field(String address){
		WaitUtils.waitForElementToAppear(getDriver(), address1TextField);
		address1TextField.sendKeys(address);
	}

	public void enterCityField(String city){
		WaitUtils.waitForElementToAppear(getDriver(), cityTextField);
		cityTextField.sendKeys(city);
	}

	public void selectState(){
		WaitUtils.waitForElementToAppear(getDriver(), stateDropDown);
		stateDropDown.selectByVisibleText("Illinois");
	}

	public void enterZipCode(String zipCode){
		WaitUtils.waitForElementToAppear(getDriver(), zipCodeField);
		zipCodeField.sendKeys(zipCode);
	}

	public void enterLocationDesc(){
		WaitUtils.waitForElementToAppear(getDriver(), locationDesc);
		locationDesc.sendKeys("Test");
	}

	public void enterAltNumber(){
		WaitUtils.waitForElementToAppear(getDriver(), altPhoneNumber);
		altPhoneNumber.sendKeys("7744565445");
	}

	public void clickConfirmPayButton(){
		WaitUtils.waitForElementToAppear(getDriver(), confirmPayBtn);
		confirmPayBtn.click();
	}


	public void enterCardNameVisaField(String nameOnCard){
		waitABit(10000);
		getDriver().switchTo().frame(0);
		WaitUtils.waitForElementToAppear(getDriver(), nameOnVisaCardField);
		nameOnVisaCardField.click();
		nameOnVisaCardField.sendKeys(nameOnCard);
	}

	public void enterCardNumberVisaField(String cardNumber){

		WaitUtils.waitForElementToAppear(getDriver(), cardNumberField);
		cardNumberField.sendKeys(cardNumber);
	}

	public void selectExpMonthField(){

		WaitUtils.waitForElementToAppear(getDriver(), monthCardCalendar);
		monthCardCalendar.selectByValue("5");
	}

	public void selectExpYearField(){

		WaitUtils.waitForElementToAppear(getDriver(), yearCardCalendar);
		yearCardCalendar.selectByValue("2022");
	}

	public void enterSecurityCodeField(){

		WaitUtils.waitForElementToAppear(getDriver(), securityCodeField);
		securityCodeField.sendKeys("411");
	}

	public void enterBillingAddressField(String address){

		WaitUtils.waitForElementToAppear(getDriver(), billingAddressField);
		billingAddressField.sendKeys(address);
	}

	public void enterBillingZipField(String zipCode){

		WaitUtils.waitForElementToAppear(getDriver(), billingZipCodeField);
		billingZipCodeField.sendKeys(zipCode);
	}

	public void clickContinueBtn(){

		WaitUtils.waitForElementToAppear(getDriver(), continueButton);
		continueButton.click();
	}

	public void clickSavePaymentBtn(){
		//getDriver().switchTo().frame(0);
		WaitUtils.waitForElementToAppear(getDriver(), submitPaymentButton);
		submitPaymentButton.click();
	}

	public WebElement displayScheduledRepairText(){
		WaitUtils.waitForElementToAppear(getDriver(), visaAfterScheduledRepairTxt);
		return visaAfterScheduledRepairTxt;
	}

	public void clickScheduleRepairCancelBtn(){
		WaitUtils.waitForElementToAppear(getDriver(), cancelRepairButton);
		cancelRepairButton.click();
		WaitUtils.waitForElementToAppear(getDriver(), cancelYesRepairButton);
		cancelYesRepairButton.click();
	}
	//button[text() = 'Close']
	public void clickCloseRefundPopUpBtn(){
		WaitUtils.waitForElementToAppear(getDriver(), refundPopUpCloseButton);
		refundPopUpCloseButton.click();
	}

}


