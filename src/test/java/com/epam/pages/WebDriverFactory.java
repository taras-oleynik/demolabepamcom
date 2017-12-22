package com.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Taras_Oliinyk on 12/21/2017.
 */
public class WebDriverFactory {

    protected static WebDriver driver;

    private static String browserType = "chrome";


    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browserType) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "D:\\Taras\\automation\\driver\\chromedriver.exe");
                    //ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;
            }
        }
        return driver;
    }

}
