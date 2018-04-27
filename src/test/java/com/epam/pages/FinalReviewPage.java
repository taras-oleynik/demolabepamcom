package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 4/24/2018.
 */
public class FinalReviewPage extends AbstractPage {


    @FindBy(css = ".checkout-review-xs .subtotal span")
    private WebElement subtotal;
    @FindBy(css = ".checkout-review-xs .shipping span")
    private WebElement delivery;
    @FindBy(css = ".checkout-review-xs .totals span")
    private WebElement orderTotal;

    @FindBy(css=".step-body #Terms1")
    private WebElement termsConditionsCheckbox;
    @FindBy(css=".step-body #placeOrder")
    private WebElement placeOrderButton;


    public String getSubtotalText() {
        return subtotal.getText();
    }

    public String getDeliveryText() {
        return delivery.getText();
    }

    public String getOrderTotalText() {
        return orderTotal.getText();
    }

    public void clickOnTermsConditions(){
        termsConditionsCheckbox.click();
    }
    public void clickOnPlaceOrderButton(){
        placeOrderButton.click();
    }

}
