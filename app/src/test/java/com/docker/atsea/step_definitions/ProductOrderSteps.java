package com.docker.atsea.step_definitions;

import com.docker.atsea.BrowserFactory;
import com.docker.atsea.page_objects.ProductsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverPool;

import static junit.framework.Assert.*;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class ProductOrderSteps {

    ProductsPage productPage;

    @Given("^I am an authenticated user$")
    public void I_am_an_authenticated_user() throws Throwable {
//        Capabilities chrome = DesiredCapabilities.chrome();
//        System.setProperty("webdriver.chrome.driver", "/Users/sarndeep/RubymineProjects/dockerDemo/atsea-sample-shop-app/app/src/test/resources/chromedriver");
        WebDriver driver = BrowserFactory.getInstance();
        // do something with the driver
        driver.get("http://localhost:8080/");
        productPage = PageFactory.initElements(driver, ProductsPage.class);

    }

    @When("^I add \"([^\"]*)\" to my shopping cart$")
    public void I_add_to_my_shopping_cart(String product) throws Throwable {
        productPage.selectProduct(product);
    }

    @Then("^my shopping cart should display \"([^\"]*)\" products$")
    public void my_shopping_cart_should_display_products(int numberOfProducts) throws Throwable {
        assertEquals(numberOfProducts, productPage.getNumberOfProductsInCart());
    }

    @And("^Total price should be \"([^\"]*)\"$")
    public void Total_price_should_be(String totalPrice) throws Throwable {
        // Express the Regexp above with the code you wish you had
        assertEquals(totalPrice, productPage.getCheckoutPage().getTotalPrice());
    }

    @When("^I checkout$")
    public void I_checkout() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @And("^enter valid card details$")
    public void enter_valid_card_details() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the system will return \"([^\"]*)\" message$")
    public void the_system_will_return_message(String message) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
