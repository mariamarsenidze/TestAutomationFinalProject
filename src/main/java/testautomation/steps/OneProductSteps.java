package testautomation.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.OneProductPage;

import java.time.Duration;

public class OneProductSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private OneProductPage oneProductPage;

    public OneProductSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.oneProductPage = new OneProductPage();
    }

    @Step("Fill name field with value: {name}")
    public OneProductSteps fillNameForm(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(oneProductPage.fillName)).sendKeys(name);
        return this;
    }

    @Step("Fill email field with value: {email}")
    public OneProductSteps fillEmailForm(String email) {
        driver.findElement(oneProductPage.fillEmail).sendKeys(email);
        return this;
    }

    @Step("Fill review text area with: {message}")
    public OneProductSteps FillReview(String message) {
        driver.findElement(oneProductPage.reviewText).sendKeys(message);
        return this;
    }

    @Step("Click on the submit review button")
    public OneProductSteps clickSubmitButton(){
        driver.findElement(oneProductPage.submitReview).click();
        return this;
    }

    @Step("Verify that 'Thank You' message is displayed")
    public boolean isThankYouDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(oneProductPage.thankYouText)).isDisplayed();
    }
}