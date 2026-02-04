package testautomation.UItests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

import java.time.Duration;
import java.util.List;

@Epic("Product Management")
@Feature("Shopping Cart")
@Story("Remove Product from Cart")
public class RemoveProductTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void addProductsOnCart() {
        homeSteps.clickProduct();
        productSteps.addProductToCart(0);
        productSteps.clickContinueShopping();
        homeSteps.clickCart();
        Assert.assertTrue(cartSteps.isCartPageDisplayed(), "Cart page is not displayed");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void removeProductsAndVerifyCart() {
        cartSteps.clickDelete();
        Assert.assertTrue(cartSteps.isCartEmpty(), "Empty cart message is not visible!");
    }
}