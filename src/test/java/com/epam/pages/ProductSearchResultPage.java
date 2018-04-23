package com.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


public class ProductSearchResultPage extends AbstractPage {

    @FindBy(css = ".product__list--wrapper .product-item")
    private List<WebElement> searchResults;
    @FindBy(css = ".js-enable-btn")
    private WebElement addToCartButton;
    @FindBy(css = "#cboxLoadedContent")
    private WebElement addToCartPopUp;
    @FindBy(css = ".headline-text .headline-text")
    private WebElement popUpMessage;





    public boolean verifyAllSearchResultsContainPrice() {

        return searchResults.stream()
                .allMatch(element -> element
                        .findElement(By.cssSelector(".price")).getText().length() == 0);
        //lambda example
        /*return searchResults.stream()
                .map(el -> el.findElement(By.cssSelector(".price")).getText().length())
                .allMatch(priceLength -> pric-eLength > 0);*/

       /* searchResults.stream().forEach(e -> e.click());
        searchResults.stream().map(e -> e.getText()).map(e -> Integer.parseInt(e));
        searchResults.stream().allMatch(e -> e.findElement(By.className("")).isDisplayed());
        searchResults.stream()
                .filter(e -> e.getText().contains("new"))
                .map(e -> e.getText())
                .map(e -> Integer.parseInt(e));*/


        /*boolean isPriceExists = true;*/



       /* for (WebElement elem : searchResults) {
            if (elem.findElement(By.cssSelector(".price")).getText().length() == 0) {
                isPriceExists = false;
                System.out.print("product #" + searchResults.indexOf(elem) + "doesn't have a price");
                break;
            }
        }
        return isPriceExists;*/
    }


    private boolean checkProductName(WebElement element,String productName){
        WebElement namedElement = element.findElement(By.cssSelector(".name"));
        String text = namedElement.getText();
        return text.contains(productName);

       // return element.findElement(By.cssSelector(".name")).getText().contains(productName);

    }
    public List<WebElement> getFirstNproductsWithName(String productName, int productsqty) {

        return searchResults.stream()
                .filter(element -> checkProductName(element,productName) )
                .limit(productsqty)
                .collect(Collectors.toList());

       /* List<WebElement> list = new ArrayList<>();*



        /*for (WebElement element : searchResults) {
            if (element.findElement(By.cssSelector(".name")).getText().contains(productName)) {
                list.add(element);
            }
            if (list.size() >= productsqty) {
                break;
            }
        }
        return list;*/
    }


    public boolean allProductsContainImage(List<WebElement> list) {


     /*   boolean allProductsContain = true;
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".thumb img")).isDisplayed()) {
                allProductsContain = false;
                break;
            }
        }
        return allProductsContain;*/
      return list.stream().
              allMatch(element -> element.findElement(By.cssSelector(".thumb img")).isDisplayed());
    }


    public boolean allProductsContainPrice(List<WebElement> list) {

        return list.stream().allMatch(element -> element.findElement(By.cssSelector(".price")).isDisplayed());


        /*  boolean allProductsContain = true;
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".price")).isDisplayed()) {
                allProductsContain = false;
                break;
            }
        }
        return allProductsContain;*/
    }


    public boolean allProductsContainButtonText(String buttonText, List<WebElement> list) {

        return list.stream().allMatch(element -> element.findElement(By.cssSelector(".js-enable-btn")).isDisplayed()
                && element.findElement(By.cssSelector(".js-enable-btn")).getAttribute("textContent").contains(buttonText));

        /*boolean allProductsContain = true;
        for (WebElement element : list) {
            if (!element.findElement(By.cssSelector(".js-enable-btn")).isDisplayed() ||
                    !element.findElement(By.cssSelector(".js-enable-btn")).getAttribute("textContent").contains(buttonText)) {
                allProductsContain = false;
                break;
            }
        }
        return allProductsContain;*/
    }
public void clickButtonFromListByName(String buttonName, int index ){

    searchResults.get(index).findElements(By.tagName("button"))
            .stream()
            .filter(button -> button.getAttribute("textContent").contains(buttonName))
            .findFirst().orElseThrow(IllegalArgumentException::new)
            .click();
}
    public void clickButtonByName(String buttonName, WebElement element) {

        element.findElements(By.tagName("button"))
                .stream()
                .filter(button -> button.getAttribute("textContent").contains(buttonName))
                .forEach(WebElement::click);

       /* for (WebElement button : element.findElements(By.tagName("button"))) {
            if (button.getAttribute("textContent").contains(buttonName)) {
                button.click();
            }
        }*/
    }



    public void clickOnSelectedButtonOnSelectedProduct(String buttonText, String productName) {
/*        WebElement element1 = searchResults.get(index);
        clickButtonByName(buttonText, element1);*/

        searchResults.stream()
        .filter(element -> element.findElement(By.cssSelector(".name")).getText().contains(productName))
                .forEach( e -> clickButtonByName(buttonText, e));

     /*   for (WebElement element : searchResults) {
            if (element.findElement(By.cssSelector(".name")).getText().contains(productName)) {
                clickButtonByName(buttonText, element);
        }*/
    }


    public boolean isPopUpVisible() {

        return popUpMessage.isDisplayed();
    }

    public ProductDetailsPage clickOnTheElement(int index) {
        searchResults.get(index).findElement(By.cssSelector(".thumb")).click();
        return new ProductDetailsPage();
    }
}
