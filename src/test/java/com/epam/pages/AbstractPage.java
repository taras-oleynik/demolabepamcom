package com.epam.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import static com.epam.service.WebDriverFactory.getDriver;

public class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void waitTillElementDisplay(WebElement elem) {
        //getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.visibilityOf(elem));

    }

    public void waiteElementSelected(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.elementToBeSelected(elem));
    }

    public void waiter2() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.alertIsPresent());//what alert? any?
    }

    public void waiteElementClicked(WebElement elem) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public void waiteNuberElementsLessThan(By locator,int count) {
//        By by = By.cssSelector("");
//        waiter4(by,5);
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator,count));
    }
    public void waiteTextPresentElementValue(WebElement elem,String text) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.textToBePresentInElementValue(elem,text));
    }
}
