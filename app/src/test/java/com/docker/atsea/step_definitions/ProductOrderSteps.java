package com.docker.atsea.step_definitions;

import com.docker.atsea.BrowserFactory;
import com.docker.atsea.page_objects.CheckoutPage;
import com.docker.atsea.page_objects.CreateUserPage;
import com.docker.atsea.page_objects.ProductsPage;
import com.docker.atsea.utils.BrowserUtils;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.h2.command.ddl.CreateUser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import ru.stqa.selenium.factory.WebDriverPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.*;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class ProductOrderSteps {

    ProductsPage productPage;
    CheckoutPage checkoutPage;
    CreateUserPage createUserPage;

    @Given("^I am an un-authenticated user$")
    public void I_am_an_un_authenticated_user() throws Throwable {
//        Capabilities chrome = DesiredCapabilities.chrome();
//        System.setProperty("webdriver.chrome.driver", "/Users/sarndeep/RubymineProjects/dockerDemo/atsea-sample-shop-app/app/src/test/resources/chromedriver");
        WebDriver driver = BrowserFactory.getInstance();
        // do something with the driver
        driver.get("http://localhost:8080/");
        productPage = PageFactory.initElements(driver, ProductsPage.class);

    }

    @Given("^I am an authenticated user$")
    public void I_am_am_authenticated_user() throws Throwable {
//        Capabilities chrome = DesiredCapabilities.chrome();
//        System.setProperty("webdriver.chrome.driver", "/Users/sarndeep/RubymineProjects/dockerDemo/atsea-sample-shop-app/app/src/test/resources/chromedriver");
        WebDriver driver = BrowserFactory.getInstance();
        // do something with the driver
        driver.get("http://localhost:8080/");
        productPage = PageFactory.initElements(driver, ProductsPage.class);
        productPage.selectCreateUser();
        createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
        createUserPage.createUser("validUser", "validPassword");
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
        checkoutPage = productPage.getCheckoutPage();
        assertEquals(totalPrice, checkoutPage.getTotalPrice());
    }


    @Then("^the system will return \"([^\"]*)\" message$")
    public void the_system_will_return_message(String message) throws Throwable {
        assertEquals(message, checkoutPage.getErrorMessage());
    }

    @When("^I enter card information$")
    public void I_enter_card_information(DataTable cardDetails) throws Throwable {
        List<Map<String, String>> cardDetailsMap = cardDetails.asMaps(String.class, String.class);
        checkoutPage.enterCardInformation(cardDetailsMap.get(0).get("firstname"),
                cardDetailsMap.get(0).get("lastname"),
                cardDetailsMap.get(0).get("cardNumber"),
                cardDetailsMap.get(0).get("cvv"),
                cardDetailsMap.get(0).get("expiryDate"));
    }

    @And("^I enter billing information$")
    public void I_enter_billing_information(DataTable billingInformation) throws Throwable {
        List<Map<String, String>> billingInformationMap = billingInformation.asMaps(String.class, String.class);

        checkoutPage.enterBillingInformation(billingInformationMap.get(0).get("company"),
                billingInformationMap.get(0).get("title"),
                billingInformationMap.get(0).get("address"),
                billingInformationMap.get(0).get("city")
        );
    }

    @And("^Submit the order to the system$")
    public void Submit_the_order_to_tge_system() throws Throwable {
        checkoutPage.completeOrder();
    }

    @Then("^the order will be successfully place$")
    public void the_order_will_be_successfully_place() throws Throwable {
        assertEquals("You have successfully placed an order!", checkoutPage.getSuccessMessage());
    }
}
