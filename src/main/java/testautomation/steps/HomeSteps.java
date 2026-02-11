package testautomation.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.HomePage;

import java.time.Duration;

public class HomeSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    public HomeSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.homePage = new HomePage();
    }

    @Step("Click Login button")
    public HomeSteps clickLogin() {
        driver.findElement(homePage.loginButton).click();
        return this;
    }

    @Step("Click Delete Account button")
    public HomeSteps clickDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.deleteAccountBtn))
                .click();

        return this;
    }

    @Step("Click Logout button")
    public HomeSteps clickLogOut() {
        driver.findElement(homePage.logOutButton).click();
        return this;
    }

    @Step("Click Products button")
    public HomeSteps clickProduct() {
        driver.findElement(homePage.productButton).click();
        return this;
    }

    @Step("Click Cart button")
    public HomeSteps clickCart() {
        driver.findElement(homePage.cartBtn).click();
        return this;
    }

    @Step("Verify Home page is visible")
    public boolean isHomeInVisible() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        homePage.validateHomeText))
                .isDisplayed();
    }

    @Step("Verify Login button is visible on Home page")
    public boolean isLogInVisible() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        homePage.loginButton))
                .isDisplayed();
    }
}
