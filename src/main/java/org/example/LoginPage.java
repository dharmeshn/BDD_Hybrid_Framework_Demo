package org.example;


import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage extends Utils{


    private By _email = By.cssSelector("input.email");
    private By _password = By.cssSelector("input.password");
    private By _loginButton = By.cssSelector(".login-button");

    public void verifyUserIsOnLoginPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/login?returnUrl=%2F", 100);
        Assert.assertTrue(driver.getCurrentUrl().contains("login?returnUrl=%2F"), "User is not on login page");
    }

    public void userShouldAbleToLogin(){
        typeText(_email, emailIDForRegistration);
        typeText(_password, LoadProp.getProperty("Password"));
        clickOnElement(_loginButton);
    }
}
