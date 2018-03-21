package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDetailsPage extends AbstractPage {

    @FindBy(css = "#accessibletabsnavigation0-0 a")
    private WebElement productDetailsField;


public boolean isPDPVisible(){

    return productDetailsField.isDisplayed();


}

}
