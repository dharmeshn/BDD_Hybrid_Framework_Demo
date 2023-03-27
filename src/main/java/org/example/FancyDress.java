package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FancyDress extends Utils{

    private By _loginButton = By.cssSelector("#customer_login_link");
    private By _email = By.cssSelector("#customer_email");
    private By _password = By.cssSelector("#customer_password");
    private By _coockieButton = By.xpath("//*[@id=\"ba-cookie-dismiss\"]");
    private By _signInButton = By.xpath("//input[@value='Sign In']");
    private By _allThemesMenu = By.cssSelector("ul[id='menu'] li[class='megaMenu-dropdown sub-menu js-megaMenu-dropdown parent-link--false '] a[class='sub-menu--link ']");
    private By _easterSubMenu = By.cssSelector("body > div:nth-child(3) > div:nth-child(4) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(6) > a:nth-child(1)");
    private By _productBabyBunny = By.cssSelector("img[alt='Baby Bunny Costume']");
    private By _productCarrotCostume = By.cssSelector("img[alt='Adult Carrot Costume']");
    private By _productKidsBunny = By.cssSelector("img[alt='Kids Bunny Costume Kit']");
    private By _addToCart = By.cssSelector(".text");
    private By _cartButton = By.cssSelector(".cart_button");
    private By _cartItemsTitle = By.xpath("//div[@class=\"sixteen columns\"]/form[1]/ul[@class='none']/li/div[1]/p[2]/a[1]");
    private By _productTitleOnProductPage = By.cssSelector(".product__title");
    private By _productSize1820OnProductPage = By.cssSelector("label[for='swatch-0-age-18-24-months-5645121880217product-template']");
    private By _productOneSizeOnProductPage = By.cssSelector("label[for='swatch-0-one-size-5657682804889product-template']");

    private By _productPriceOnProductPage = By.cssSelector(".money");
    private By _productQtyOnProductPage = By.cssSelector("#quantity");
    private By _productTitleInShoppingCart = By.cssSelector("p[class='cart_product_title'] a");
    private By _productSizeInShoppingCart = By.cssSelector("p[class='meta'] span:nth-child(2)");
    private By _productPriceInShoppingCart = By.cssSelector("p[class='price_total'] span[class='money ']");
    private By _productQtyInShoppingCart = By.cssSelector(".quantity");






//    @Test
    public void registeredUserAddedProductsInTheCarts(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.fancydress.com/");
        clickOnElement(_loginButton);
        typeText(_email, "xyz@abc.com");
        typeText(_password, "test@123");
        clickOnElement(_coockieButton);
        clickOnElement(_signInButton);
        moveToElement(_allThemesMenu);
        waitForElementToBeClickable(_easterSubMenu,25);
        moveToElementAndClick(_easterSubMenu);
        waitForElementToBeVisible(_productBabyBunny, 20);
        clickOnElement(_productBabyBunny);
        HashMap<String, String> product1 = new HashMap<>();
        product1.put("Title", driver.findElement(_productTitleOnProductPage).getText());
        product1.put("Price", driver.findElement(_productPriceOnProductPage).getText());
        product1.put("Size", driver.findElement(_productSize1820OnProductPage).getText());
        product1.put("Qty", driver.findElement(_productQtyOnProductPage).getAttribute("size"));
        clickOnElement(_addToCart);
//        driver.navigate().back();
//        driver.navigate().back();
//        waitForElementToBeVisible(_productCarrotCostume, 25);
//        clickOnElement(_productCarrotCostume);
//        HashMap<String, String> product2 = new HashMap<>();
//        product2.put("Title", driver.findElement(_productTitleOnProductPage).getText());
//        product2.put("Price", driver.findElement(_productPriceOnProductPage).getText());
//        product2.put("Size", driver.findElement(_productOneSizeOnProductPage).getText());
//        product2.put("Qty", driver.findElement(_productQtyOnProductPage).getText());
//        clickOnElement(_addToCart);
//        driver.navigate().back();
//        driver.navigate().back();
//        waitForElementToBeVisible(_productKidsBunny, 30);
//        clickOnElement(_productKidsBunny);
//        HashMap<String, String> product3 = new HashMap<>();
//        product3.put("Title", driver.findElement(_productTitleOnProductPage).getText());
//        product3.put("Price", driver.findElement(_productPriceOnProductPage).getText());
//        product3.put("Size", driver.findElement(_productOneSizeOnProductPage).getText());
//        product3.put("Qty", driver.findElement(_productQtyOnProductPage).getText());
//        clickOnElement(_addToCart);
        clickOnElement(_cartButton);
//        int totalProductAddedInCart = driver.findElements(_cartItemsTitle).size();
//        System.out.println(totalProductAddedInCart);

//        for (Object ele :new  ArrayList<>()){
//
//          ArrayList<String> addedInCartProductsTitle= new ArrayList<>(driver.findElements(By.xpath("//div[@class=\"sixteen columns\"]/form[1]/ul[1]/li/div[1]/p[2]/a[1]"));
//        }
//
//
//
//        for (int i = 0; i <= totalProductAddedInCart; i++) {
            HashMap<String, String> addedInCartProducts=new HashMap<>();
            addedInCartProducts.put("Title", driver.findElement(_productTitleInShoppingCart).getText().toUpperCase());
            addedInCartProducts.put("Price", driver.findElement(_productPriceInShoppingCart).getText());
            addedInCartProducts.put("Size", driver.findElement(_productSizeInShoppingCart).getText().toUpperCase());
            addedInCartProducts.put("Qty", driver.findElement(_productQtyInShoppingCart).getAttribute("size"));
//        }

        System.out.println(product1);
        System.out.println(addedInCartProducts);
//        List<String> cartItemsTitle = new ArrayList<String>();
////        cartItemsTitle = driver.findElements(_cartItemsTitle);
//        for (WebElement title:cartItemsTitle) {
//            System.out.println(title);
//        }

    if (product1.equals(addedInCartProducts)){
        System.out.println("Correct product added to cart");
    }else {
        System.out.println("Wrong product added to cart");
    }

//        driver.close();
    }

}
