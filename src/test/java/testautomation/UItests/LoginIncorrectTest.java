package testautomation.UItests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

@Epic("User Management")
@Feature("Login Functionality")
@Story("Login with Incorrect Credentials")
public class LoginIncorrectTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void openLoginPage() {
        homeSteps.clickLogin();
        Assert.assertTrue(loginSteps.isLoginHeaderVisible(), "Login Page is not visible");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void fillForm() {
        loginSteps.inputEmail("blabla@gmail.com")
                .inputPassword("blabla")
                .submit();
        Assert.assertTrue(loginSteps.isEmailIncorrect(), "Error message for incorrect email/password is not displayed");
    }
}