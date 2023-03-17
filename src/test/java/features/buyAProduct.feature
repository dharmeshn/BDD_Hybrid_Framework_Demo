Feature: As a registered user, user want to add product to cart,
  So user can buy a product successfully

  @e2e @regression @buyAProduct
  Scenario: When registered user add product into cart and proceed to check out
  then user should able to buy product successfully

    Given registered user is on login page
    When user enter valid username and password and click on login button
    Then user should able logged in and navigate to homepage
    When user hover on electronics category  and click on camera & photo page
    And  user click on add to cart button of any product
    Then product has been added to shopping cart message should appear
    When user click on shopping cart
    Then user should be navigated to shopping cart page and verify correct product has been added
    When user tick on check box of terms of service and click on check out button
    Then user should be navigated to billing address section on check out page
    When user filled all mandatory details on section billing address and click on continue
    Then user should be navigated to shipping method section on check out page
    When user select shipping method radio button and click on continue
    Then user should be navigated to payment method section on check out page
    When user select payment method radio button and click on continue
    Then user should be navigated to payment information section on check out page
    When user enter payment information and click on continue
    Then user should be navigated to confirm order section on check out page
    When user click on confirm button
    Then user should be navigated to check out completed page
    And order should be placed and order processed message should display


