package testautomation.UItests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

@Epic("User Management")
@Feature("Login Functionality")
@Story("Positive Login and Account Deletion")
public class LoginTest extends BaseTest {

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

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 3)
    public void fillForm() {
        loginSteps.inputEmail("bla123@gmail.com")
                .inputPassword("Bla1234")
                .submit();
        Assert.assertTrue(loginSteps.isLoggedUser(), "User Is Not Logged in");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void deleteAccount() {
        homeSteps.clickDelete();
    }
}