package org.example;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homepage extends Utils{

    private By _register = By.cssSelector("a.ico-register");
    private By _electronicsCategory = By.linkText("Electronics");
    private By _computersCategory = By.linkText("Computers");
    private By _logIn = By.cssSelector("a.ico-login");
    private By _myAccount = By.cssSelector("a.ico-account");

    private By _cameraAndPhoto = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/camera-photo']");
    private By _notebooks = By.xpath("//ul[@class='top-menu notmobile']//a[@href='/notebooks']");

//    @Test
    public void userShouldNavigateToRegisterPage(){
        clickOnElement(_register);
    }

    public void userShouldNavigateToLoginPage(){
        clickOnElement(_logIn);
    }

    public void verifyUserIsOnHomepage(){
        waitForUrlToBe(LoadProp.getProperty("Homepage_url"), 50);
        Assert.assertTrue(driver.getCurrentUrl().contains(LoadProp.getProperty("Homepage_url")),
                "User is not on homepage");
    }

    public void userHoverMouseOnElectronicsCategoryAndClickOnCameraAndPhoto(){
        waitForElementToBeClickable(_electronicsCategory, 35);
        moveToElement(_electronicsCategory);
        waitForElementToBeVisible(_cameraAndPhoto, 40);
        moveToElementAndClick(_cameraAndPhoto);
    }

    public void userShouldNavigateToCustomerInfoPage(){
        waitForUrlToBe(LoadProp.getProperty("Homepage_url"), 60);
        clickOnElement(_myAccount);
    }

}
