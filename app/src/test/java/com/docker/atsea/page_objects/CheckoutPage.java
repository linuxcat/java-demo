package com.docker.atsea.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class CheckoutPage {

    @FindBy(css= ".totalFinal")
    private WebElement totalFinal;


    public String getTotalPrice() {
        return totalFinal.findElements(By.cssSelector("span")).get(1).getText();
    }
}
