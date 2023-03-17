package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ShoppingCartPage extends Utils{

    private By _firstAddedProduct = By.xpath(
            "//tr/td[3]/a[@href=\"/leica-t-mirrorless-digital-camera\"]");
    private By _termsOfServiceCheckBox = By.cssSelector("input#termsofservice");
    private By _checkOutButton = By.cssSelector("button#checkout");

    public void verifyUserIsOnShoppingCartPage() {
        waitForUrlToBe("https://demo.nopcommerce.com/cart", 60);
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"),
                "User is not on shopping cart page");
    }

    public void verifyCorrectProductHasBeenAddedToShoppingCart(){
        String expectedProducTitle = LoadProp.getProperty("AddedProductTitle");
        Assert.assertEquals(getTextFromElement(_firstAddedProduct),expectedProducTitle,
                "Wrong Product has been added to cart");
    }

    public void userAcceptTermsOfServiceAndClickOnCheckOutButton(){
        clickOnElement(_termsOfServiceCheckBox);
        clickOnElement(_checkOutButton);
    }
}
