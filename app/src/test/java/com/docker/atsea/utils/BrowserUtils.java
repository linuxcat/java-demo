package com.docker.atsea.utils;

import com.docker.atsea.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class BrowserUtils {

    public static void enterText(String text, WebElement element) {
        element.click();
        sleep(400);
        Actions actions = new Actions(BrowserFactory.getInstance());
        actions.moveToElement(element);
        actions.click();
        System.out.println("Entering: " + text);
        actions.sendKeys(text);
        actions.build().perform();

    }

    public static void waitForElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(BrowserFactory.getInstance(), 10);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void sleep(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
