package testautomation.pages;

import org.openqa.selenium.By;

public class CartPage {
    public By deleteBtn = By.xpath("//a[@data-product-id='1']");
    public By checkoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    public By emptyCart = By.id("empty_cart");

}
