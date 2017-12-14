package com.docker.atsea.page_objects;

import com.docker.atsea.utils.BrowserUtils;
import cucumber.api.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.UUID;


import static com.docker.atsea.utils.BrowserUtils.enterText;
import static com.docker.atsea.utils.BrowserUtils.waitForElement;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class CreateUserPage {

    @FindBy(name="username")
    private WebElement usernameTextBox;

    @FindBy(name="password")
    private WebElement passwordTextBox;

    @FindBy(css = ".createFormButton")
    private WebElement signUpButton;

    @FindBy(css =".successButton")
    private WebElement successButton;


    public void createUser(String username, String password) {
        usernameTextBox.click();
        usernameTextBox.sendKeys("u");
        usernameTextBox.click();
        usernameTextBox.sendKeys(username + UUID.randomUUID().toString());
        passwordTextBox.click();
        passwordTextBox.sendKeys("u");
        passwordTextBox.click();
        passwordTextBox.sendKeys(password);
        signUpButton.click();
        waitForElement(successButton);
        successButton.click();
    }
}
