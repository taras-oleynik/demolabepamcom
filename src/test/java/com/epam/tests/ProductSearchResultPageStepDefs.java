package com.epam.tests;

import com.epam.pages.HomePage;
import com.epam.pages.ProductSearchResultPage;
import cucumber.api.PendingException;
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
    List<WebElement> filteredList = new ArrayList<>();

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
    public void click_button_for_product(String buttonName, String productName) {
        productSearchResultPage.clickOnSelectedButtonOnSelectedProduct(buttonName, productName);
    }

    @Then("^add to cart confirmation pop-up appears$")
    public void add_to_cart_confirmation_pop_up_appears() {
        throw new PendingException();
    }

    @When("^click on product \"([^\"]*)\" on search result page$")
    public void click_on_product_on_search_result_page(String arg1) {
        //TODO
    }

    @Then("^I am redirected on product details page$")
    public void i_am_redirected_on_product_details_page() {
        //TODO
    }
}
