package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Taras_Oliinyk on 1/30/2018.
 */
public class NavigationBar extends AbstractFragment {

    @FindBy(css = "[title~=Webcams]")
    private WebElement webcams;

    public void selectWebcam(){
        webcams.click();
    }
}
