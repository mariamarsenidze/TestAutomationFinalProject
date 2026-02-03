package testautomation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.ProductPage;

import java.time.Duration;

public class ProductSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private ProductPage productPage;

    public ProductSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.productPage = new ProductPage();

    }



}
