package com.epam.tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import static com.epam.service.WebDriverFactory.getDriver;
import static com.epam.service.WebDriverFactory.setDriverToNull;


public class Hooks {

    @Before
    public void openBrowser(){
        getDriver().manage().deleteAllCookies();
        getDriver().get("https://ecse00100c69.epam.com:9002/sparkstorefront/");
    }

    @After
    public void closeBrowser(){
        getDriver().quit();
        setDriverToNull();
    }
}
