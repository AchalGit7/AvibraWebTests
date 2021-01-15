@LoriMobile
Feature: Validate on-board functionality for user with Super easy quote for phone protection

  @ScheduleRepair
  Scenario Outline: I should be able to verify flow for super easy quote for phone protection
    When User enters correct url and redirected to login screen
    And User is able to login after entering valid email and password
    And User clicks on schedule repair button
    And User select issue <issue> from dropdown
    And User selects incident date from the calendar
    And User enters the issue description and click on next button
    And User select email radio button and click on next button
    And User enters details of Address like Address1 <address> city <city> zipcode <zipCode> and then clicks on next button
    And User selects timeslot <scheduleTimeSlot> to schedule repair
    And User clicks on Confirm and Pay button
    And User enter and submit card details like name <nameOnCard> card number <cardNumber> expiration month year security code billing address <address> and billing zipcode <zipCode>
    And User successfully schedules the repair and All set text is displayed
    And User successfully cancels the schedule repair after clicking on cancel button

    Examples:
      | issue         | address         | city     | zipCode | scheduleTimeSlot | nameOnCard | cardNumber       |
      | Camera - Back | 218 W Kinzie St | Illinois | 60654   | 12:30            | Achal      | 4111111111111111 |