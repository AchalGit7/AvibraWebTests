@LoriMobile
Feature: Validate on-board functionality for user with Super easy quote for phone protection

  @ReimbursementClaim
  Scenario Outline: I should be able to verify flow for super easy quote for phone protection
    When User enters correct url and is able to login successfully after entering valid email and password
    And User clicks on reimbursement claim button
    And User select issue <issue> radio button
    And User enters incident date
    And User enters issue description and click on next button
    And User clicks Confirm and Pay button
    And User enter card details like name <nameOnCard> card number <cardNumber> expiration month year security code billing address <address> billing zipcode <zipCode> and submit it
    And User successfully files the reimbursement claim
    And User successfully cancels the filed reimbursement claim after clicking on cancel button

    Examples:
      | issue         | address         | zipCode | nameOnCard | cardNumber       |
      | Camera - Back | 218 W Kinzie St | 60654   | Achal      | 4111111111111111 |