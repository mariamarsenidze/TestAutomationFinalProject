package testautomation.UItests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

@Epic("User Management")
@Feature("Registration")
@Story("Full User Registration and Deletion Flow")
public class RegistrationTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void openSignupPage() {
        registerSteps.clickSignupLogin();
        Assert.assertTrue(registerSteps.isNewUserSignupVisible(), "New User Signup! text not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void enterInitialSignupInfo() {
        String email = "Jora" + System.currentTimeMillis() + "@gmail.com";
        registerSteps.enterNameAndEmail("Jora", email);
        Assert.assertTrue(registerSteps.isEnterAccountInfoVisible(), "Enter Account Information not visible");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 4)
    public void fillFullRegistrationForm() {
        registerSteps.fillAccountInformation();
        Assert.assertTrue(registerSteps.isAccountCreatedVisible(), "ACCOUNT CREATED! is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void verifyLoginAndUserSession() {
        registerSteps.continueAfterCreate();
        Assert.assertTrue(registerSteps.isLoggedInVisible(), "Logged in as username not visible");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6)
    public void cleanupAccount() {
        registerSteps.deleteAccount();
        Assert.assertTrue(registerSteps.isAccountDeletedVisible(), "ACCOUNT DELETED! text not visible");
        registerSteps.continueAfterDelete();
    }
}