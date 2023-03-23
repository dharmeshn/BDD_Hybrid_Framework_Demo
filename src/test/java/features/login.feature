Feature: As a registered user, user want to login,
  So user can change password successfully.

  @login @regression @myAccount
  Scenario: When registered user login with valid username and password
  then user should able to change password successfully

    Given registered user is on login page
    When user enter valid username and password and click on login button
    Then user should able logged in and navigate to homepage
    When user click on my account page
    Then user should navigate to customer info page
    When user click on change password
    Then user should navigate to customer change password page
    When user enter old and new password details and click on change password button
    Then user should able to change password successfully

