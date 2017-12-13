package com.docker.atsea.page_objects;

import com.docker.atsea.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.docker.atsea.utils.BrowserUtils.enterText;
import static com.docker.atsea.utils.BrowserUtils.sleep;
import static com.docker.atsea.utils.BrowserUtils.waitForElement;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class CheckoutPage {

    @FindBy(css= ".totalFinal")
    private WebElement totalFinal;

    @FindBy(name ="firstName")
    private WebElement firstName;

    @FindBy(name ="lastName")
    private WebElement lastName;

    @FindBy(name ="cardNumber")
    private WebElement cardNumber;

    @FindBy(name ="cvv")
    private WebElement cvv;

    @FindBy(name ="expirationDate")
    private WebElement expiryDate;

    @FindBy(name ="company")
    private WebElement company;

    @FindBy(name ="title")
    private WebElement title;

    @FindBy(name ="address")
    private WebElement address;

    @FindBy(name ="city")
    private WebElement city;

    @FindBy(css = "button[type=submit]")
    private WebElement submitButton;

    @FindBy(className = "loginErrorMessage")
    private WebElement errorMessage;



    public String getTotalPrice() {
        return totalFinal.findElements(By.cssSelector("span")).get(1).getText();
    }

    public void enterCardInformation(String fName, String lName, String cNumber, String cvvNumber, String expDate) {
        firstName.click();
        firstName.sendKeys(fName);
//        enterText(fName, firstName);
        enterText(lName, lastName);
        enterText(cNumber, cardNumber);
        enterText(cvvNumber, cvv);
        enterText(expDate, expiryDate);

    }

    public void enterBillingInformation(String companyNameText, String titleText, String addressText, String cityText) {
        enterText(companyNameText, company);
        enterText(titleText, title);
        enterText(addressText, address);
        enterText(cityText, city);
    }

    public void completeOrder() {
        submitButton.click();
    }

    public String getErrorMessage() {
        waitForElement(errorMessage);
        return errorMessage.getText();
    }

}
