package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 1/30/2018.
 */
public class Search extends AbstractFragment{

    @FindBy(css = "#js-site-search-input")
    private WebElement searchField;
    @FindBy(css = ".js_search_button")
    private WebElement enterButton;



    public ProductSearchResultPage searchUponRequest(String keyWord){

        searchField.sendKeys(keyWord);
        enterButton.click();
        return new ProductSearchResultPage();

    }



}
