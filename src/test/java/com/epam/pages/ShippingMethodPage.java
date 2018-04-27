package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 4/24/2018.
 */
public class ShippingMethodPage extends AbstractPage{
    @FindBy(css="#deliveryMethodSubmit")
    private WebElement nextButton;



    public FinalReviewPage clickonNextButton(){
        nextButton.click();

        return new FinalReviewPage();
    }
}
