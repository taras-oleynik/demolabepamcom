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
        //lambda example
        /*return searchResults.stream()
                .map(el -> el.findElement(By.cssSelector(".price")).getText().length())
                .allMatch(priceLength -> priceLength > 0);*/

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
        boolean allProductsContain = true;
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".thumb img")).isDisplayed()) {
                allProductsContain = false;
                break;
            }
        }
        return allProductsContain;
    }


    public boolean allProductsContainPrice(List<WebElement> list) {
        boolean allProductsContain = true;
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".price")).isDisplayed()) {
                allProductsContain = false;
                break;
            }
        }
        return allProductsContain;
    }


    public boolean allProductsContainButtonText(String buttonText, List<WebElement> list) {
        //lambda example
        /*return list.stream().allMatch(element -> element.findElement(By.cssSelector(".js-enable-btn")).isDisplayed()
                && element.findElement(By.cssSelector(".js-enable-btn")).getAttribute("textContent").contains(buttonText));*/

         boolean allProductsContain = true;
         for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".js-enable-btn")).isDisplayed()||
                    !element.findElement(By.cssSelector(".js-enable-btn")).getAttribute("textContent").contains(buttonText)) {
                allProductsContain = false;
                break;
            }
        }
        return allProductsContain;
    }

    private void clickButtonByName(String buttonName, WebElement element) {
        //lambda example
        /*element.findElements(By.tagName("button"))
                .stream()
                .filter(button -> button.getAttribute("textContent").contains(buttonName))
                .forEach(WebElement::click);*/

        for (WebElement button : element.findElements(By.tagName("button"))) {
            if (button.getAttribute("textContent").contains(buttonName)) {
                button.click();
            }
        }
    }

    public void clickOnSelectedButtonOnSelectedProduct(String buttonText, String productName) {
        for (WebElement element : searchResults) {
            if (element.findElement(By.cssSelector(".name")).getText().contains(productName)) {
                clickButtonByName(buttonText, element);
            }
        }
    }
}
