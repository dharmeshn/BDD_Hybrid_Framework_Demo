package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils{

    private By _registrationResultMsg = By.className("result");

    private By _continueButton = By.xpath("//a[contains(@class, 'continue')]");

    public void verifyUserIsOnRegistrationResultPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/registerresult/1?returnUrl=/", 15);
        Assert.assertTrue(driver.getCurrentUrl().contains("registerresult/1?returnUrl="),
                "User is not on registration result page");
    }

    public void verifyUserRegistrationDoneSuccessfully(){
        String exceptedRegistrationResultMsg = "Your registration completed";

        String actualRegistrationResultMsg = getTextFromElement(_registrationResultMsg);
        Assert.assertEquals(actualRegistrationResultMsg,exceptedRegistrationResultMsg,
                "Registration Failed" );
    }

    public void clickOnContinueButton(){
        clickOnElement(_continueButton);
    }
}
