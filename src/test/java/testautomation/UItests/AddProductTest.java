package testautomation.UItests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

import java.util.List;

@Epic("Product Management")
@Feature("Shopping Cart")
@Story("Product Purchase Flow")
public class AddProductTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void addProductsAndVerifyCart() {
        homeSteps.clickProduct();

        productSteps.addProductToCart(0);
        productSteps.clickContinueShopping();

        productSteps.addProductToCart(1);
        homeSteps.clickCart();

        List<WebElement> cartItems = getDriver().findElements(By.xpath("//tr[contains(@id,'product-')]"));
        Assert.assertEquals(cartItems.size(), 2);

        for (WebElement item : cartItems) {
            Assert.assertFalse(item.findElement(By.className("cart_price")).getText().isEmpty());
            Assert.assertFalse(item.findElement(By.className("cart_quantity")).getText().isEmpty());
            Assert.assertFalse(item.findElement(By.className("cart_total")).getText().isEmpty());
        }
    }
}