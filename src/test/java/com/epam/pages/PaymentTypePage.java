package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 4/17/2018.
 */
public class PaymentTypePage extends AbstractPage {


    @FindBy(css = ".totals")
    //@FindBy(xpath = "//div[@class='totals']/span")
    private WebElement total;

    @FindBy(css = ".subtotal")
    private WebElement subTotal;

    @FindBy(css="#PaymentTypeSelection_ACCOUNT")
    private WebElement accountPaymentRadioButton;

    @FindBy(css="#choosePaymentType_continue_button")
    private WebElement nextButton;


    public String getOrderSubTotal() {


        return subTotal.getText();
    }

    public String getOrderTotal() {


        return total.getText();
    }

    public void selectAccountPaymentRadioButton(){
        accountPaymentRadioButton.click();
    }

    public ShippingMethodPage clickNextButton(){

        nextButton.click();
        return new ShippingMethodPage();
    }
}
