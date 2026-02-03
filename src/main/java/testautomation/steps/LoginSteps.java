package testautomation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.LoginPage;

import java.time.Duration;

public class LoginSteps {


    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.loginPage = new LoginPage();

    }

    public LoginSteps inputEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.emailInput));
        emailInput.sendKeys(email);
        return this;
    }
    public LoginSteps inputPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.passwordInput));
        passwordInput.sendKeys(password);

        return this;
    }
    public LoginSteps submit() {
        driver.findElement(loginPage.submitButton).click();
        return this;
    }


}
