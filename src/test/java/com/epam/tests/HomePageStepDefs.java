package com.epam.tests;

import com.epam.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HomePageStepDefs {

    HomePage homePage = new HomePage();


    @When("^I am on home page$")
    public void iAmOnHomePage() throws Throwable {
        assertEquals("Powertools Site | Homepage", homePage.getPageTitle());
    }

    public void checkSearchUponRecuest() {
        homePage.search.searchUponRequest("camera").verifyAllSearchResultsContainPrice();

    }


    @Then("^On the home page I can view logo, Sign in Register, icon, search field, navigation menu, banner$")
    public void onTheHomePageICanViewLogoSignInRegisterIconSearchFieldNavigationMenuBanner() throws Throwable {
        assertTrue("register button not found", homePage.isSignInVisible());
        assertTrue("Logo not found", homePage.isLogoVisiable());
        assertTrue("Search not found", homePage.isSearchVisiable());
        assertTrue("Navigation is not found", homePage.isNavigationMenuVisiable());


    }
}
