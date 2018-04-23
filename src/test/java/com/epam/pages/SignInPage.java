package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 4/15/2018.
 */
public class SignInPage extends AbstractPage {

    @FindBy(css = "#j_username")
    private WebElement emailAddressInput;
    @FindBy(css = "#j_password")
    private WebElement passwordInput;

    @FindBy(css=".btn-primary")
    private WebElement loginAndCheckoutButton;

    public void setEmailAddress(String email){
        emailAddressInput.sendKeys(email);
    }
    public void setPassword(String password){
        passwordInput.sendKeys(password);
    }

    public PaymentTypePage clickOnLoginAndCheckoutButton(){
        loginAndCheckoutButton.click();
        return new PaymentTypePage();
    }


}
