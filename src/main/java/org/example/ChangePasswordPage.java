package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ChangePasswordPage extends Utils{

    private By _oldPassword = By.xpath("//input[@id='OldPassword']");
    private By _newPassword = By.xpath("//input[@id='NewPassword']");
    private By _confirmNewPassword = By.xpath("//input[@id='ConfirmNewPassword']");
    private By _changePasswordButton = By.xpath("//button[@class='button-1 change-password-button']");
    private By _passwordChangeMsg = By.cssSelector(".content");

    public void verifyUserIsOnChangePasswordPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/customer/changepassword", 35);
        Assert.assertTrue(driver.getCurrentUrl().contains("customer/changepassword"),
                "User is not on change password page");
    }

    public void userEnterNewPasswordAndClickOnChangePasswordButton(){
        typeText(_oldPassword, LoadProp.getProperty("Password"));
        typeText(_newPassword, LoadProp.getProperty("NewPassword"));
        typeText(_confirmNewPassword, LoadProp.getProperty("NewPassword"));
        clickOnElement(_changePasswordButton);
    }
    public void userShouldAbleToChangePasswordSuccessfully(){
        String actualPasswordChangeMsg = "Password was changed";
        String expectedPasswordChangeMsg = getTextFromElement(_passwordChangeMsg);
        Assert.assertEquals(actualPasswordChangeMsg, expectedPasswordChangeMsg, "Password does not changed");
    }
}
