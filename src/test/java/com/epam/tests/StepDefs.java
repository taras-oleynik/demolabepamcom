package com.epam.tests;

import com.epam.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.epam.pages.WebDriverFactory.getDriver;
import static org.junit.Assert.assertTrue;


/**
 * Created by Taras_Oliinyk on 12/15/2017.
 */
public class StepDefs {

    /*static WebDriver driver;*/
    HomePage homePage = new HomePage();

    @Given("I am an anonymous customer with clear cookies")
    public void clearCookies() {

        getDriver().manage().deleteAllCookies();
    }

    @When("^I am on home page$")
    public void iAmOnHomePage() throws Throwable {

        getDriver().get("https://ecsc00100f01.epam.com:82/yacceleratorstorefront/electronics/en/");
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^On the home page I can view logo, Sign in Register, icon, search field, navigation menu, banner$")
    public void onTheHomePageICanViewLogoSignInRegisterIconSearchFieldNavigationMenuBanner() throws Throwable {
        assertTrue("register button not found", homePage.isSignInVisible());
        assertTrue("Logo not found",homePage.isLogoVisiable());
        assertTrue("Search not found",homePage.isSearchVisiable());
        assertTrue("Navigation is not found", homePage.isNavigationMenuVisiable());



        // Write code here that turns the phrase above into concrete actions

    }
}
