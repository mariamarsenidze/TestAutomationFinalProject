package testautomation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.CartPage;
import testautomation.pages.RegisterPage;

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




}
