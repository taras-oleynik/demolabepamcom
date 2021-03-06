package com.epam.pages;

import com.epam.service.WebDriverFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.epam.service.WebDriverFactory.getDriver;


public class HomePage extends AbstractPage {

    public Search search = new Search();
    public NavigationBar navigationBar = new NavigationBar();
    @FindBy(css = ".liOffcanvas a")
    private WebElement registerButton;
    @FindBy(css = ".banner__component img")
    private WebElement siteLogo;
    @FindBy(css = "#js-site-search-input")
    private WebElement searchField;
    @FindBy(css = ".input-group input")
    private WebElement navigationMenu;


    public ProductSearchResultPage findProductWithExactProductNumber(String exactProductNumber) {
        searchField.sendKeys(exactProductNumber);
        searchField.sendKeys(Keys.ENTER);
        return new ProductSearchResultPage();
    }

 /*   public List<WebElement> filterProductByPrice() {
        List<WebElement> allProductsCamera;
        allProductsCamera= search.searchUponRequest();

    }*/

    public String getPageTitle() {
        return getDriver().getTitle();//needs to be confirm

    }

    public boolean isSearchWorks() {
        search.searchUponRequest("");
        return true;

    }

    public boolean isNavigationWorks() {
        navigationBar.selectWebcam();
        return true;
    }


    public boolean isSignInVisible() {

        return registerButton.isDisplayed();
    }

    public boolean isLogoVisiable() {
        waitTillElementDisplay(siteLogo);
        return siteLogo.isDisplayed();
    }

    public boolean isSearchVisiable() {
        waitTillElementDisplay(searchField);
        return searchField.isDisplayed();
    }

    public boolean isNavigationMenuVisiable() {
        waitTillElementDisplay(navigationMenu);
        return navigationMenu.isDisplayed();
    }

    public ProductSearchResultPage searchForProduct(String productName) {

        searchField.sendKeys(productName);
        searchField.sendKeys(Keys.ENTER);
        return new ProductSearchResultPage();
    }
}
