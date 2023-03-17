package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CustomerInfoPage extends Utils{

    private By _changePassword = By.xpath("//a[@href='/customer/changepassword']") ;

    public void verifyUserIsOnCustomerInfoPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/customer/info", 30);
        Assert.assertTrue(driver.getCurrentUrl().contains("customer/info"),
                "User is not on customer info page");
    }

    public void userClickOnChangePassword(){
        clickOnElement(_changePassword);
    }
}
