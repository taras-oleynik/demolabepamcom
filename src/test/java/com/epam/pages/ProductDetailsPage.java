package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 3/14/2018.
 */
public class ProductDetailsPage extends AbstractPage {

    @FindBy(css = "#accessibletabsnavigation0-0 a")
    private WebElement productDetailsField;


public boolean isPDPVisible(){

    return productDetailsField.isDisplayed();


}

}
