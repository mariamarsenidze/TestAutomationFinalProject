package testautomation.steps;

import io.qameta.allure.Step;
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

    @Step("Input email: {email}")
    public LoginSteps inputEmail(String email) {
        WebElement emailInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginPage.emailInput
                )
        );
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Input password")
    public LoginSteps inputPassword(String password) {
        WebElement passwordInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        loginPage.passwordInput
                )
        );
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Submit login form")
    public LoginSteps submit() {
        driver.findElement(loginPage.submitButton).click();
        return this;
    }

    @Step("Verify Login page header is visible")
    public boolean isLoginHeaderVisible() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        loginPage.loginHeader))
                .isDisplayed();
    }

    @Step("Verify user is logged in")
    public boolean isLoggedUser() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        loginPage.userLoggedIn))
                .isDisplayed();
    }

    @Step("Verify account deleted message is visible")
    public boolean isAccountDeleted() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        loginPage.deletedText))
                .isDisplayed();
    }

    @Step("Verify incorrect email error message is visible")
    public boolean isEmailIncorrect() {
        return wait
                .until(ExpectedConditions.visibilityOfElementLocated(
                        loginPage.incorrectEmailText))
                .isDisplayed();
    }
}
