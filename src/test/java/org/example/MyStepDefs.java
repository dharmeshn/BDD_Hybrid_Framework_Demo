package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepDefs {
    Homepage homepage = new Homepage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    LoginPage loginPage = new LoginPage();
    CustomerInfoPage customerInfoPage = new CustomerInfoPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    CameraAndPhotoPage cameraAndPhotoPage = new CameraAndPhotoPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckOutPage checkOutPage = new CheckOutPage();

    @Given("registered user is on login page")
    public void registered_user_is_on_login_page() {
        homepage.userShouldNavigateToRegisterPage();
        registrationPage.verifyUserIsOnRegistrationPage();
        registrationPage.verifyUserShouldAbleToRegisterSuccessfully();
        registrationResultPage.verifyUserIsOnRegistrationResultPage();
        registrationResultPage.verifyUserRegistrationDoneSuccessfully();
        registrationResultPage.clickOnContinueButton();
        homepage.verifyUserIsOnHomepage();
        homepage.userShouldNavigateToLoginPage();
    }
    @When("user enter valid username and password and click on login button")
    public void user_enter_valid_username_and_password_and_click_on_login_button() {
        loginPage.verifyUserIsOnLoginPage();
        loginPage.userShouldAbleToLogin();
    }
    @Then("user should able logged in and navigate to homepage")
    public void user_should_able_logged_in_and_navigate_to_homepage() {
        homepage.verifyUserIsOnHomepage();
    }
    @When("user click on my account page")
    public void user_click_on_my_account_page() {
        homepage.userShouldNavigateToCustomerInfoPage();
    }
    @Then("user should navigate to customer info page")
    public void user_should_navigate_to_customer_info_page() {
        customerInfoPage.verifyUserIsOnCustomerInfoPage();
    }
    @When("user click on change password")
    public void user_click_on_change_password() {
        customerInfoPage.userClickOnChangePassword();
    }
    @Then("user should navigate to customer change password page")
    public void user_should_navigate_to_customer_change_password_page() {
        changePasswordPage.verifyUserIsOnChangePasswordPage();
    }
    @When("user enter old and new password details and click on change password button")
    public void user_enter_old_and_new_password_details_and_click_on_change_password_button() {
        changePasswordPage.userEnterNewPasswordAndClickOnChangePasswordButton();
    }
    @Then("user should able to change password successfully")
    public void user_should_able_to_change_password_successfully() {
        changePasswordPage.userShouldAbleToChangePasswordSuccessfully();
    }
    @When("user hover on electronics category  and click on camera & photo page")
    public void userHoverOnElectronicsCategoryAndClickOnCameraPhotoPage() {
        homepage.userHoverMouseOnElectronicsCategoryAndClickOnCameraAndPhoto();
    }
    @And("user click on add to cart button of any product")
    public void userClickOnAddToCartButtonOfAnyProduct() {
        cameraAndPhotoPage.userClickOnAddToCartButtonOfLeicaTMirrorlessDigitalCamera();
    }
    @Then("product has been added to shopping cart message should appear")
    public void productHasBeenAddedToShoppingCartMessageShouldAppear() {
        cameraAndPhotoPage.verifyProductHasBeenAddedToShoppingCartMessagePopUpShouldAppear();
    }
    @When("user click on shopping cart")
    public void userClickOnShoppingCart() {
        cameraAndPhotoPage.userClickOnShoppingCart();
    }
    @Then("user should be navigated to shopping cart page and verify correct product has been added")
    public void userShouldBeNavigatedToShoppingCartPageAndVerifyCorrectProductHasBeenAdded() {
        shoppingCartPage.verifyUserIsOnShoppingCartPage();
        shoppingCartPage.verifyCorrectProductHasBeenAddedToShoppingCart();
    }
    @When("user tick on check box of terms of service and click on check out button")
    public void userTickOnCheckBoxOfTermsOfServiceAndClickOnCheckOutButton() {
        shoppingCartPage.userAcceptTermsOfServiceAndClickOnCheckOutButton();
    }
    @Then("user should be navigated to billing address section on check out page")
    public void userShouldBeNavigatedToBillingAddressSectionOnCheckOutPage() {
        checkOutPage.verifyUserIsOnBillingAddressSectionOnCheckOutPage();

    }
    @When("user filled all mandatory details on section billing address and click on continue")
    public void userFilledAllMandatoryDetailsOnSectionBillingAddressAndClickOnContinue() {
        checkOutPage.userEnterAllMandatoryDetailsInBillingSectionAndClickOnContinueButton();
    }
    @Then("user should be navigated to shipping method section on check out page")
    public void userShouldBeNavigatedToShippingMethodSectionOnCheckOutPage() {
        checkOutPage.verifyUserIsOnShippingMethodSectionOnCheckOutPage();
    }
    @When("user select shipping method radio button and click on continue")
    public void userSelectShippingMethodRadioButtonAndClickOnContinue() {
        checkOutPage.userSelectShippingMethodRadioButtonAndClickOnContinue();
    }
    @Then("user should be navigated to payment method section on check out page")
    public void userShouldBeNavigatedToPaymentMethodSectionOnCheckOutPage() {
        checkOutPage.verifyUserIsOnPaymentMethodSectionOnCheckOutPage();
    }
    @When("user select payment method radio button and click on continue")
    public void userSelectPaymentMethodRadioButtonAndClickOnContinue() {
        checkOutPage.userSelectPaymentMethodRadioButtonAndClickOnContinue();
    }
    @Then("user should be navigated to payment information section on check out page")
    public void userShouldBeNavigatedToPaymentInformationSectionOnCheckOutPage() {
        checkOutPage.verifyUserIsOnPaymentInformationSectionOnCheckOutPage();
    }
    @When("user enter payment information and click on continue")
    public void userEnterPaymentInformationAndClickOnContinue() {
        checkOutPage.userEnterPaymentInformationAndClickOnContinue();
    }
    @Then("user should be navigated to confirm order section on check out page")
    public void userShouldBeNavigatedToConfirmOrderSectionOnCheckOutPage() {
        checkOutPage.verifyUserIsOnConfirmOrderSectionOnCheckOutPage();
    }
    @When("user click on confirm button")
    public void userClickOnConfirmButton() {
        checkOutPage.userClickOnConfirmButton();
    }

    @Then("user should be navigated to check out completed page")
    public void userShouldBeNavigatedToCheckOutCompletedPage() {
        checkOutPage.verifyUserIsOnCheckOutCompletedPage();
    }
    @And("order should be placed and order processed message should display")
    public void orderShouldBePlacedAndOrderProcessedMessageShouldDisplay() {
        checkOutPage.orderShouldBePlacedAndOrderProcessedMessageShouldDisplay();
    }
}
