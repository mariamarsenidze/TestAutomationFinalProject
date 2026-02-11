package testautomation.UItests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

@Epic("Product Management")
@Feature("Search Functionality")
@Story("Search for Specific Product")
public class SearchProductTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void ValidateHomePage() {
        Assert.assertTrue(homeSteps.isHomeInVisible(), "Home Page is not visible");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void openProductPage() {
        homeSteps.clickProduct()
                .clickProduct();
        Assert.assertTrue(productSteps.isProductDisplayed(), "Product Page is not displayed");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void searchProduct() {
        productSteps.inputProduct("Top")
                .clickSearch();

        Assert.assertTrue(productSteps.isSearchedProductDisplayed(), "Searched Products title is not visible!");

        Assert.assertTrue(productSteps.getProductsCount() > 0, "No products found!");
    }
}