package testautomation.UItests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

@Epic("Customer Support")
@Feature("Contact Form")
@Story("Submit Contact Us Request")
public class ContactFormTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void submitContactUsForm() {
        contactSteps.openContactUs();

        contactSteps.fillContactForm(
                "Test User",
                "test@mail.com",
                "Test Subject",
                "Test message"
        );

        String filePath = contactSteps.createTempFile();
        contactSteps.uploadFile(filePath);
        contactSteps.submitFormAndAcceptAlert();

        Assert.assertTrue(contactSteps.isSuccessMessageDisplayed());
        contactSteps.clickHomeButton();

        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }
}