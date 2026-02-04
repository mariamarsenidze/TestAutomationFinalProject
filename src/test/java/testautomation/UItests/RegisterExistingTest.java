package testautomation.UItests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

@Epic("User Management")
@Feature("Registration")
@Story("Register with Already Existing Email")
public class RegisterExistingTest extends BaseTest {

    private final String existingEmail = "BlaBla_permanent@gmail.com";

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void registerWithExistingEmail() {
        registerSteps.openHomePage();
        registerSteps.clickSignupLogin();

        registerSteps.enterNameAndEmailPermanent("bla", existingEmail);

        Assert.assertTrue(registerSteps.isEmailExistErrorVisible(),
                "Error message 'Email Address already exist!' is not visible");
    }
}