package testautomation.UItests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

@Epic("Product Management")
@Feature("Product Reviews")
@Story("Add Review Flow")
public class AddReviewTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void openProductPage() {
        homeSteps.clickProduct()
                .clickProduct();
        Assert.assertTrue(productSteps.isProductDisplayed(), "Product Page is not displayed");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3)
    public void viewProduct() {
        productSteps.clickRandomViewProduct();
        Assert.assertTrue(productSteps.isReviewVisible(), "Review Page is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void fillReviewForm() {
        oneProductSteps.fillNameForm("user")
                .fillEmailForm("user1@gmail.com")
                .FillReview("The quality is very good, I am satisfied!")
                .clickSubmitButton();
        Assert.assertTrue(oneProductSteps.isThankYouDisplayed(), "Thank You Page is not displayed");
    }
}