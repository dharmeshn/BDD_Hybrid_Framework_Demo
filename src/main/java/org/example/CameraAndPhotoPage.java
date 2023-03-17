package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CameraAndPhotoPage extends Utils{

    private By _addToCartButtonLeicaTMirrorlessDigitalCamera = By.xpath(
            "//div[@class='item-grid']/div[3]/div//div[@class='buttons']/button[1]");
    private By _shoppingCart = By.xpath("//p/a[@href='/cart']");
    private By _productAddedMsg = By.cssSelector("p.content");


    public void verifyUserIsOnCameraAndPhotoPage(){
        waitForUrlToBe("https://demo.nopcommerce.com/camera-photo", 60);
        Assert.assertTrue(driver.getCurrentUrl().contains("camera-photo"),
                "User is not on camera and photo page");
    }
    public void userClickOnAddToCartButtonOfLeicaTMirrorlessDigitalCamera(){
//        waitForElementToBeClickable(_addToCartButtonLeicaTMirrorlessDigitalCamera, 50);
        clickOnElement(_addToCartButtonLeicaTMirrorlessDigitalCamera);
    }

    public void verifyProductHasBeenAddedToShoppingCartMessagePopUpShouldAppear(){
        String expectedPopupMsg = "The product has been added to your shopping cart";
        waitForElementToBeVisible(_productAddedMsg, 60);
        String actualPopupMsg = getTextFromElement(_productAddedMsg);
        System.out.println(actualPopupMsg);
        Assert.assertEquals(actualPopupMsg, expectedPopupMsg,
                "Product has been added message did not popup");
    }

    public void userClickOnShoppingCart(){
        clickOnElement(_shoppingCart);
    }
}
