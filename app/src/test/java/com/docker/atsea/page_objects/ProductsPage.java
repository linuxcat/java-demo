package com.docker.atsea.page_objects;

import com.docker.atsea.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by sarndeep on 13/12/2017.
 */
public class ProductsPage {

    @FindBy(css = ".productListWrapper .tile")
    private List<WebElement> products;

    @FindBy(css = ".cartDigit")
    private WebElement productsInCart;

    @FindBy(css = ".checkout-button")
    private WebElement checkoutButton;


    public int getNumberOfProducts() {
        return products.size();
    }

    public void selectProduct(String productName) {
       WebElement productToSelect =  products.stream().filter(product -> product.findElement(By.className("tileTitle")).getText().equals(productName)).findFirst()
                .orElseThrow(() -> new RuntimeException(productName + " Not Found"));
        productToSelect.findElement(By.cssSelector(".titleBottom .tileAdd")).click();
    }

    public int getNumberOfProductsInCart() {
        return Integer.valueOf(productsInCart.getText());
    }

    public CheckoutPage getCheckoutPage() {
        checkoutButton.click();;
        return PageFactory.initElements(BrowserFactory.getInstance(), CheckoutPage.class);
    }


}
