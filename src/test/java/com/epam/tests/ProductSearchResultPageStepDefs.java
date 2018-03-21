package com.epam.tests;

import com.epam.pages.HomePage;
import com.epam.pages.ProductDetailsPage;
import com.epam.pages.ProductSearchResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class ProductSearchResultPageStepDefs {
    HomePage homePage = new HomePage();
    ProductSearchResultPage productSearchResultPage = new ProductSearchResultPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    List<WebElement> filteredList = new ArrayList<WebElement>();

    @And("^I search for \"([^\"]*)\"$")
    public void searchFor(String searchQuery) {
        homePage.searchForProduct(searchQuery);
    }

    @And("^I am redirected to a Search page$")
    public void redirectionToSearchPage() {

    }

    @When("^I find (\\d+) products with name \"([^\"]*)\"$")
    public void findingProductsWithName(int numberOfProducts, String productName) {
        filteredList = productSearchResultPage.getFirstNproductsWithName(productName, numberOfProducts);
    }

    @Then("^all products contain image, price, button \"([^\"]*)\"$")
    public void allProductContainsImagePriceButton(String buttonName) {
        assertTrue("not all products have images", productSearchResultPage.allProductsContainImage(filteredList));
        assertTrue("not all products have prices", productSearchResultPage.allProductsContainPrice(filteredList));
        assertTrue("not all products have buttons or buttons texts are missing", productSearchResultPage.allProductsContainButtonText(buttonName, filteredList));

    }

    @When("^click \"([^\"]*)\" button for product \"([^\"]*)\"$")
    public void clickButtonForProduct(String buttonName, String productName) {
        productSearchResultPage.clickOnSelectedButtonOnSelectedProduct(buttonName, productName);
    }

    @Then("^add to cart confirmation pop-up appears$")
    public void addToCartConfirmationPopUpAppears() {
        assertTrue("pop up not visible",productSearchResultPage.isPopUpVisible());

    }

    @When("^click on product \"([^\"]*)\" on search result page$")
    public void clickOnProductOnSearchResultPage(String arg1) {
        int firstElement = 0;
        productSearchResultPage.clickOnTheElement(firstElement);
    }

    @Then("^I am redirected on product details page$")
    public void iamRedirectedOnProductDetailsPage() {
        assertTrue("PDP is not opened",productDetailsPage.isPDPVisible());
    }

    /*@Then("^add to cart confirmation pop-up appears$")
    public void confirmationPopUpAppears() throws Throwable {
        assertTrue("pop up is visible",productSearchResultPage.isPopUpAddToCartVisible());


    }*/
}
