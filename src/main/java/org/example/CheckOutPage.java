package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckOutPage extends Utils{

    private By _firstName = By.cssSelector("input#BillingNewAddress_FirstName");
    private By _lastName = By.cssSelector("input#BillingNewAddress_LastName");
    private By _countryDropDownField = By.xpath(
            "//select[@data-trigger=\"country-select\"]");
    private By _stateDropDownField = By.xpath(
            "//span[@data-valmsg-for=\"BillingNewAddress.StateProvinceId\"]");
    private By _cityTextField = By.cssSelector("input#BillingNewAddress_City");
    private By _address1Field = By.cssSelector("input#BillingNewAddress_Address1");
    private By _postalCode = By.cssSelector("input#BillingNewAddress_ZipPostalCode");
    private By _phoneNumber = By.cssSelector("input#BillingNewAddress_PhoneNumber");
    private By _continueButtonOnBilling = By.xpath("//button[@onclick=\"Billing.save()\"]");
    private By _nextDayAirRadioButton = By.cssSelector("input#shippingoption_1");
    private By _continueButtonOnShippingMethod = By.xpath(
            "//button[@onclick='ShippingMethod.save()']");
    private By _creditCardRadioButton = By.cssSelector("input#paymentmethod_1");
    private By _continueButtonOnPaymentMethod = By.xpath(
            "//button[@onclick='PaymentMethod.save()']");
    private By _selectCreditCardType = By.cssSelector("select#CreditCardType");
    private By _cardHolderNameField = By.cssSelector("input#CardholderName");
    private By _cardNumberField = By.cssSelector("input#CardNumber");
    private By _selectExpireMonth = By.cssSelector("select#ExpireMonth");
    private By _selectExpireYear = By.cssSelector("select#ExpireYear");
    private By _cardCodeField = By.cssSelector("input#CardCode");
    private By _continueButtonOnPaymentInfo = By.xpath(
            "//button[@onclick='PaymentInfo.save()']");
    private By _confirmButtonOnCheckOutPage = By.xpath(
            "//button[@onclick='ConfirmOrder.save()']");
    private By _actualOrderProcessedMsg = By.cssSelector("div.section.order-completed div.title");

    public void verifyUserIsOnBillingAddressSectionOnCheckOutPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/onepagecheckout#opc-billing", 65);
        Assert.assertTrue(driver.getCurrentUrl().contains("onepagecheckout#opc-billing"),
                "User is not on billing section check out page");
    }
    public void userEnterAllMandatoryDetailsInBillingSectionAndClickOnContinueButton(){
        selectFromDropDownList_ByVisibleText(_countryDropDownField, LoadProp.getProperty("Country"));
        typeText(_cityTextField, LoadProp.getProperty("City"));
        typeText(_address1Field, LoadProp.getProperty("Address1"));
        typeText(_postalCode, LoadProp.getProperty("PostalCode"));
        typeText(_phoneNumber, LoadProp.getProperty("PhoneNumber"));
        clickOnElement(_continueButtonOnBilling);


    }

    public void verifyUserIsOnShippingMethodSectionOnCheckOutPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method",
                70);
        Assert.assertTrue(driver.getCurrentUrl().contains("onepagecheckout#opc-shipping_method"),
                "User is not on shipping method check out page");
    }

    public void userSelectShippingMethodRadioButtonAndClickOnContinue(){
        clickOnElement(_nextDayAirRadioButton);
        clickOnElement(_continueButtonOnShippingMethod);
    }

    public void verifyUserIsOnPaymentMethodSectionOnCheckOutPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/onepagecheckout#opc-payment_method",
                75);
        Assert.assertTrue(driver.getCurrentUrl().contains("onepagecheckout#opc-payment_method"),
                "User is not on payment method check out page");
    }

    public void userSelectPaymentMethodRadioButtonAndClickOnContinue(){
        clickOnElement(_creditCardRadioButton);
        clickOnElement(_continueButtonOnPaymentMethod);
    }

    public void verifyUserIsOnPaymentInformationSectionOnCheckOutPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/onepagecheckout#opc-payment_info",
                80);
        Assert.assertTrue(driver.getCurrentUrl().contains("onepagecheckout#opc-payment_info"),
                "User is not on payment information check out page");
    }

    public void userEnterPaymentInformationAndClickOnContinue() {
        selectFromDropDownList_ByVisibleText(_selectCreditCardType, LoadProp.getProperty("CreditCardType"));
        typeText(_cardHolderNameField, LoadProp.getProperty("CardHolderName"));
        typeText(_cardNumberField, LoadProp.getProperty("CardNumber"));
        selectFromDropDownList_ByVisibleText(_selectExpireMonth, LoadProp.getProperty("ExpireMonth"));
        selectFromDropDownList_ByVisibleText(_selectExpireYear, LoadProp.getProperty("ExpireYear"));
        typeText(_cardCodeField, LoadProp.getProperty("CardCode"));
        clickOnElement(_continueButtonOnPaymentInfo);
    }
    public void verifyUserIsOnConfirmOrderSectionOnCheckOutPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order",
                85);
        Assert.assertTrue(driver.getCurrentUrl().contains("onepagecheckout#opc-confirm_order"),
                "User is not on confirm order check out page");
    }

    public void userClickOnConfirmButton(){
        clickOnElement(_confirmButtonOnCheckOutPage);
    }

    public void verifyUserIsOnCheckOutCompletedPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/checkout/completed",
                85);
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout/completed"),
                "User is not on check out completed page");
    }
    public void orderShouldBePlacedAndOrderProcessedMessageShouldDisplay() {
        String expectedOrderProcessedMsg = "Your order has been successfully processed!";
        String actualOrderProcessedMsg = getTextFromElement(_actualOrderProcessedMsg);
        Assert.assertEquals(actualOrderProcessedMsg, expectedOrderProcessedMsg,
                "Order not processed");
    }
}
