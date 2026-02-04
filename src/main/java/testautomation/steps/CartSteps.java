package testautomation.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.CartPage;

import java.time.Duration;

public class CartSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.cartPage = new CartPage();
    }

    @Step("Delete product from cart")
    public CartSteps clickDelete() {
        driver.findElement(cartPage.deleteBtn).click();
        return this;
    }

    @Step("Verify Cart page is displayed")
    public boolean isCartPageDisplayed() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(cartPage.checkoutBtn))
                .isDisplayed();
    }

    @Step("Verify cart is empty")
    public boolean isCartEmpty() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(cartPage.emptyCart))
                .isDisplayed();
    }
}
