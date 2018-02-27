package com.epam.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {

    private static WebDriver driver;
    private static Browser browserType = Browser.CHROME;

    public static WebDriver getDriver() {
        if (driver == null) {
            if (browserType == Browser.FIREFOX) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            } else if (browserType == Browser.CHROME) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
            }
        }
        return driver;
    }

    public static WebDriver setDriverToNull() {
        return driver = null;
    }

    enum Browser {
        CHROME, FIREFOX
    }
}
