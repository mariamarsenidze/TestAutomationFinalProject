package testautomation.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.RegisterPage;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private RegisterPage registerPage;

    public RegisterSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.registerPage = new RegisterPage();
    }

    @Step("Open Home Page")
    public void openHomePage() {
        driver.get("https://automationexercise.com");
    }

    @Step("Click on Signup/Login button")
    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.signupLoginBtn)).click();
    }

    @Step("Verify if 'New User Signup!' text is visible")
    public boolean isNewUserSignupVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.newUserSignupText)).isDisplayed();
    }

    @Step("Enter name: {name} and email: {email} for signup")
    public void enterNameAndEmail(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.nameInput)).sendKeys(name);
        driver.findElement(registerPage.emailInput).sendKeys(email);
        driver.findElement(registerPage.signupButton).click();
    }

    @Step("Verify if 'ENTER ACCOUNT INFORMATION' is visible")
    public boolean isEnterAccountInfoVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.enterAccountInfoText)).isDisplayed();
    }

    @Step("Fill detailed account information form")
    public void fillAccountInformation() {
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.titleMrsRadio)).click();
        driver.findElement(registerPage.passwordInput).sendKeys("ibsu1995");

        new Select(driver.findElement(registerPage.daysDropdown)).selectByVisibleText("12");
        new Select(driver.findElement(registerPage.monthsDropdown)).selectByVisibleText("February");
        new Select(driver.findElement(registerPage.yearsDropdown)).selectByVisibleText("1995");

        driver.findElement(registerPage.newsletterCheckbox).click();
        driver.findElement(registerPage.offersCheckbox).click();

        driver.findElement(registerPage.firstNameInput).sendKeys("final");
        driver.findElement(registerPage.lastNameInput).sendKeys("project");
        driver.findElement(registerPage.companyInput).sendKeys("IBSU");
        driver.findElement(registerPage.address1Input).sendKeys("2, David Agmashenebeli Alley 13 km");
        driver.findElement(registerPage.address2Input).sendKeys("2, David Agmashenebeli Alley 13 km");

        new Select(driver.findElement(registerPage.countryDropdown)).selectByVisibleText("Canada");

        driver.findElement(registerPage.stateInput).sendKeys("New York");
        driver.findElement(registerPage.cityInput).sendKeys("Tbilisi");
        driver.findElement(registerPage.zipcodeInput).sendKeys("0131");
        driver.findElement(registerPage.mobileInput).sendKeys("0322800064");

        driver.findElement(registerPage.createAccountBtn).click();
    }

    @Step("Verify if account was successfully created")
    public boolean isAccountCreatedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.accountCreatedText)).isDisplayed();
    }

    @Step("Click 'Continue' after account creation")
    public void continueAfterCreate() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(registerPage.continueBtn));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    @Step("Verify if user is logged in and 'Logged in as' is visible")
    public boolean isLoggedInVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.loggedInText)).isDisplayed();
    }

    @Step("Click on 'Delete Account' button")
    public void deleteAccount() {
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(registerPage.deleteAccountBtn));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);
    }

    @Step("Verify if account was successfully deleted")
    public boolean isAccountDeletedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.accountDeletedText)).isDisplayed();
    }

    @Step("Click 'Continue' after account deletion")
    public void continueAfterDelete() {
        wait.until(ExpectedConditions.elementToBeClickable(registerPage.continueDeleteBtn)).click();
    }

    @Step("Verify if email already exists error is visible")
    public boolean isEmailExistErrorVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                registerPage.emailAlreadyExistText)).isDisplayed();
    }

    @Step("Ensure user exists by registering if needed for: {name} ({email})")
    public void enterNameAndEmailPermanent(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.nameInput)).sendKeys(name);
        driver.findElement(registerPage.emailInput).sendKeys(email);
        driver.findElement(registerPage.signupButton).click();

        if (driver.findElements(registerPage.enterAccountInfoText).size() > 0) {
            fillAccountInformation();
            continueAfterCreate();
            clickSignupLogin();

            wait.until(ExpectedConditions.visibilityOfElementLocated(registerPage.nameInput)).sendKeys(name);
            driver.findElement(registerPage.emailInput).sendKeys(email);
            driver.findElement(registerPage.signupButton).click();
        }
    }
}