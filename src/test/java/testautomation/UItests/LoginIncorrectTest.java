package testautomation.UItests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;
import java.time.Duration;

public class LoginIncorrectTest extends BaseTest {
    @Test(priority=1)
    public void ValidateHomePage() {

        WebElement element = driver.findElement((By.xpath("//h2[text()='Features Items']")));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test(priority = 2)
    public void openLoginPage() {
        homeSteps.clickLogin();
        WebElement element = driver.findElement((By.xpath("//h2[text()='Login to your account']")));
        Assert.assertTrue(element.isDisplayed());
    }

    @Test(priority = 3)
    public void fillForm() {
        loginSteps.inputEmail("blabla@gmail.com")
                .inputPassword("blabla")
                .submit();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[text()='Your email or password is incorrect!']")));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
}
