package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 3/16/2018.
 */
public class CheckoutPage extends AbstractPage {

    @FindBy(css = ".add-to-cart-button")
    private WebElement checkOutButton;

    @FindBy(xpath = "//div[contains (text(), 'Subtotal')]/following-sibling::div[1]")
    private WebElement subTotal;
    @FindBy(xpath = "//div[contains (text(), 'Order Total')]/following-sibling::div[1]")
    private WebElement total;


    public CartPage clickOnCheckoutButton(String buttonText) {

        waitTillElementDisplay(checkOutButton);

        if (checkOutButton.getText().equalsIgnoreCase(buttonText)) {
            checkOutButton.click();
        } else {
            throw new RuntimeException("expected " + buttonText + " got " + checkOutButton.getText());
        }
        return new CartPage();

    }





}

