package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ProductSearchResultPage extends AbstractPage {
    @FindBy(css = ".product__list--wrapper .product-item")
    private List<WebElement> searchResults;
    @FindBy(css = ".js-enable-btn")
    private WebElement addToCartButton;


    public boolean verifyAllSearchResultsContainPrice() {
        boolean isPriceExists = true;
        for (WebElement elem : searchResults) {
            if (elem.findElement(By.cssSelector(".price")).getText().length() == 0) {
                isPriceExists = false;
                System.out.print("product #" + searchResults.indexOf(elem) + "doesn't have a price");
                break;
            }
        }
        return isPriceExists;
    }

    public boolean blabla() {
        return searchResults.stream()
                .map(el -> el.findElement(By.cssSelector(".price")).getText().length())
                .allMatch(l -> l > 0);
    }

    public List<WebElement> getFirstNproductsWithName(String productName, int productsqty) {
        List<WebElement> list = new ArrayList<>();
        for (WebElement element : searchResults) {
            if (element.findElement(By.cssSelector(".name")).getText().contains(productName)) {
                list.add(element);
            }
            if (list.size() >= productsqty) {
                break;
            }
        }
        return list;
    }


    public boolean allProductsContainImage(List<WebElement> list) {
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".thumb img")).isDisplayed()) {
                return false;
            }
        }
        return true;
    }


    public boolean allProductsContainPrice(List<WebElement> list) {
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".price")).isDisplayed()) {
                return false;
            }
        }
        return true;
    }


    public boolean allProductsContainButtonText(String buttonText, List<WebElement> list) {
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".js-enable-btn")).isDisplayed()&&
                    element.findElement(By.cssSelector(".js-enable-btn")).getText().contains(buttonText)) {
                return false;
            }
        }
        return true;
    }

    public void clickButtonByName(String buttonName, WebElement element){
      if(element.findElement(By.tagName("button")).getText().contains(buttonName)){
          element.click();
      }
    }

    public void clickOnSelectedButtonOnSelectedProduct(String buttonText, String productName, List<WebElement> list) {
        for (WebElement element : list){
            if(element.findElement(By.cssSelector(".name")).getText().contains(productName)){
                //element.findElement(By.cssSelector(".js-enable-btn")).click();
                clickButtonByName(buttonText, element);
            }
        }
    }
}
