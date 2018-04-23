package com.epam.tests;

import com.epam.pages.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

/*Given I select "Add to cart" for product "1934793"
        And I select "Checkout" in cart pop-up
        And I am redirected to the cart page
        And I can view order summary*/


public class CheckoutPageStepDefs {
    private static final int FIRST_ELEMENT_OF_LIST = 0;
    // Given I select "Add to cart" for product "1934793"
    ProductSearchResultPage productSearchResultPage = new ProductSearchResultPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    HomePage homePage = new HomePage();
    CartPage cartPage = new CartPage();
    SignInPage signInPage = new SignInPage();
    PaymentTypePage paymentTypePage = new PaymentTypePage();

    //Given I select "Add to cart" for product "693923"
    @Given("^I select \"([^\"]*)\" for product \"([^\"]*)\"$")
    public void selectForProduct(String buttonName, String productNumber) throws Throwable {
        ProductSearchResultPage searchResultPage = homePage.findProductWithExactProductNumber(productNumber);
        productSearchResultPage.clickButtonFromListByName(buttonName, FIRST_ELEMENT_OF_LIST);


    }

    //And I select "Checkout" in cart pop-up
    @Given("^I select \"([^\"]*)\" in cart pop-up$")
    public void selectCheckoutInCartPopUp(String buttonName) throws Throwable {
        checkoutPage.clickOnCheckoutButton(buttonName);

    }


    // And I am redirected to the cart page rederection in past step
    @Given("^I am redirected to the cart page$")
    public void iamRedirectedToCartPage() throws Throwable {
        assertEquals("CART", cartPage.getCartTextonPage());

    }

    @Given("^I can view order summary$")
    public void iCanViewOrderSummary(DataTable table) throws Throwable {

        List<List<String>> data = table.raw();
        assertEquals(data.get(1).get(0), cartPage.getOrderSubTotal());
        assertEquals(data.get(1).get(1), cartPage.getOrderTotal());


        //System.out.println(data.get(1).get(0));
    }

    @Given("^I click \"([^\"]*)\" button after redirect to cart page$")
    public void iClickOnbuttonAndRidirectToSignInPage(String buttonName) throws Throwable {
        cartPage.clickOnCheckoutButtonOnCartPage(buttonName);
    }

    @Given("^I set \"([^\"]*)\" as e-mail address$")
    public void iSetAsEmail_address(String email) throws Throwable {
        signInPage.setEmailAddress(email);
    }

    @Given("^I set \"([^\"]*)\" as a password$")
    public void iSetAsPassword(String password) throws Throwable {
        signInPage.setPassword(password);
        signInPage.clickOnLoginAndCheckoutButton();
        Thread.sleep(2000);
    }

    @Given("^I have the following final review$")
    public void iHaveFinalReview(DataTable filalReviewTable) throws Throwable {
        List<List<String>> data = filalReviewTable.raw();
        assertEquals(data.get(1).get(0), paymentTypePage.getOrderSubTotal().replaceAll("\\w+\\:\\n", ""));
        assertEquals(data.get(1).get(0), paymentTypePage.getOrderTotal().replaceAll("[^\\d\\\\.\\\\$]", ""));
    }

    @Given("^I fill in delivery address information$")
    public void i_fill_in_delivery_address_information(DataTable arg1) throws Throwable {

    }

    @When("^I press \"([^\"]*)\" button on delivery address page$")
    public void i_press_button_on_delivery_address_page(String arg1) throws Throwable {

    }

    @When("^I am redirected to multicheckout delivery method page$")
    public void i_am_redirected_to_multicheckout_delivery_method_page() throws Throwable {

    }

   /* @When("^I have the following final review$")
    public void i_have_the_following_final_review(DataTable arg1) throws Throwable {

    }*/

    @When("^I select \"([^\"]*)\" delivery method$")
    public void i_select_delivery_method(String arg1) throws Throwable {

    }

    @When("^I press \"([^\"]*)\" button on delivery method page$")
    public void i_press_button_on_delivery_method_page(String arg1) throws Throwable {

    }

    @When("^I am redirected to multicheckout payment method page$")
    public void i_am_redirected_to_multicheckout_payment_method_page() throws Throwable {

    }

    @When("^I select to use my delivery address$")
    public void i_select_to_use_my_delivery_address() throws Throwable {

    }

    @When("^I agree with terms and conditions$")
    public void i_agree_with_terms_and_conditions() throws Throwable {

    }

    @When("^I press \"([^\"]*)\" button on payment method page$")
    public void i_press_button_on_payment_method_page(String arg1) throws Throwable {


    }

    @When("^I am redirected to WorldPay page$")
    public void i_am_redirected_to_WorldPay_page() throws Throwable {

    }

    @When("^I enter test card data$")
    public void i_enter_test_card_data(DataTable arg1) throws Throwable {

    }

    @When("^I click Make payment button$")
    public void i_click_Make_payment_button() throws Throwable {

    }

    @Then("^I am redirected to checkout confirmation page$")
    public void i_am_redirected_to_checkout_confirmation_page() throws Throwable {

    }

    @Then("^I have the following final review at order confirmation page$")
    public void i_have_the_following_final_review_at_order_confirmation_page(DataTable arg1) throws Throwable {

    }

    @Then("^checkout message is \"([^\"]*)\"$")
    public void checkout_message_is(String arg1) throws Throwable {

    }

    @Then("^I can obtain an order number$")
    public void i_can_obtain_an_order_number() throws Throwable {

    }

    @Then("^I press \"([^\"]*)\" button on checkout confirmation page$")
    public void i_press_button_on_checkout_confirmation_page(String arg1) throws Throwable {

    }

    @Then("^I am redirected to the home page$")
    public void i_am_redirected_to_the_home_page() throws Throwable {

    }

    @Then("^mini cart icon on home page shows (\\d+) items in cart$")
    public void mini_cart_icon_on_home_page_shows_items_in_cart(int arg1) throws Throwable {

    }


}
