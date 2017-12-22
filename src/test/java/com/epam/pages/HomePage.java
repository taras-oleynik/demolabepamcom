package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.epam.tests.StepDefs.getDriver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "a[href*='login']")
    private WebElement registerButton;
    @FindBy(css = ".siteLogo img")
    private WebElement siteLogo;
    @FindBy(css = "#input_SearchBox")
    private WebElement searchField;
    @FindBy(css = ".navigationbarcollectioncomponent")
    private WebElement navigationMenu;



    public boolean isSignInVisible() {

        return registerButton.isDisplayed();
    }

    public boolean isLogoVisiable() {
        return siteLogo.isDisplayed();
    }

    public boolean isSearchVisiable() {
        return searchField.isDisplayed();
    }

    public boolean isNavigationMenuVisiable() {
        return navigationMenu.isDisplayed();
    }
}
