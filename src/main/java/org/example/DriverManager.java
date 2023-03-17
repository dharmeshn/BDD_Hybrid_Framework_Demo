package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager extends Utils {
    public static final String USERNAME = LoadProp.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadProp.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY +
            "@hub-cloud.browserstack.com/wd/hub";
    boolean runIncloud = Boolean.parseBoolean(LoadProp.getProperty("Cloud"));
//    boolean runIncloud = Boolean.parseBoolean(System.getProperty("Cloud"));
    String browserName = LoadProp.getProperty("Browser");
//    String browserName = System.getProperty("Browser");

    MutableCapabilities capabilities = new MutableCapabilities();

    public void openBrowser() {
        // Running in cloud
        if (runIncloud) {
            System.out.println("Running in cloud");
            // Connect to cloud
            if (browserName.equalsIgnoreCase("Edge")) {
                // Connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                browserstackOptions.put("buildName", "Website build #5");
                capabilities.setCapability("bstack:options", browserstackOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }

            } else if (browserName.equalsIgnoreCase("Firefox")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                browserstackOptions.put("buildName", "Website build #5");
                capabilities.setCapability("bstack:options", browserstackOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), capabilities);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            // Run in locally
            System.out.println("Running Locally");

            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                // assign value to driver varible as a chrome driver to perform task in Chrome browser
                driver = new ChromeDriver(chromeOptions);
            } else if (browserName.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("MobileChrome")) {
                Map <String, String> mobileEmulation = new HashMap<String, String>();
                mobileEmulation.put("deviceName", "iPhone X");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                driver = new ChromeDriver(chromeOptions);
            } else if (browserName.equalsIgnoreCase("MobileFirefox")) {
                Map <String, String> mobileEmulation = new HashMap<String, String>();
                mobileEmulation.put("deviceName", "iPhone X");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("mobileEmulation", mobileEmulation);
                driver = new FirefoxDriver(firefoxOptions);
            } else {
                System.out.println("Your browser name is wrong or missing implementation for : " + browserName);
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(LoadProp.getProperty("Homepage_url"));

    }


    public void closeBrowser() {
        driver.quit();
    }
}
