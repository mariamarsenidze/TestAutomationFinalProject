package testautomation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.HomePage;

import java.time.Duration;

public class HomeSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    public HomeSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.homePage = new HomePage();

    }

    public HomeSteps clickLogin() {
        driver.findElement(homePage.loginButton).click();
        return this;
    }



}
