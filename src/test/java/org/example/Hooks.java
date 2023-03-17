package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hooks extends Utils {
    DriverManager driverManager = new DriverManager();
//    Utils utils = new Utils();

    @Before
    public void setUp() {
        driverManager.openBrowser();    // openBrowser method called from DriverManager class
    }

    @After   // used After annotation from cucumber-java to run this method after running every method
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] sourceFile = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourceFile, "image/jpg/png", "screenshot");
        }
        driverManager.closeBrowser();
    }
}
