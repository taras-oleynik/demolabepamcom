package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 3/27/2018.
 */
public class CartPage extends AbstractPage {

    @FindBy(css = ".active")
    private WebElement cartIdOnPage;

    @FindBy(xpath = "//div[contains (text(), 'Subtotal')]/following-sibling::div[1]")
    private WebElement subTotal;
    @FindBy(xpath = "//div[contains (text(), 'Order Total')]/following-sibling::div[1]")
    private WebElement total;
    @FindBy(xpath = "//div[contains(@class, 'col-sm-4')]//*[contains(@class,'js-continue-checkout-button')]")
    private WebElement checkOutButton;


    public String getCartTextonPage() {

        return cartIdOnPage.getText();
    }

    public String getOrderSubTotal() {
        return subTotal.getText();
    }

    public String getOrderTotal() {
        return total.getText();
    }


    public SignInPage clickOnCheckoutButtonOnCartPage(String buttonText) {


        if (checkOutButton.getText().equalsIgnoreCase(buttonText)) {
            checkOutButton.click();
        } else {
            throw new RuntimeException("expected " + buttonText + " got " + checkOutButton.getText());
        }
        return new SignInPage();

    }

}
