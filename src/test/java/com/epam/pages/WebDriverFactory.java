package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Taras_Oliinyk on 12/21/2017.
 */
public class WebDriverFactory {


   // public static final WebDriver DEFAULT_FF = new FirefoxDriver();
 //  protected static WebDriver driver;

    private static String browserType = "chrome";


    public static WebDriver getDriver() {
        WebDriver driver = null;
        if (browserType=="firefox") {
            driver = new FirefoxDriver();
        } else if (browserType=="chrome") {
            System.setProperty("webdriver.chrome.driver", "D:\\Taras\\automation\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;




 
    }
}


