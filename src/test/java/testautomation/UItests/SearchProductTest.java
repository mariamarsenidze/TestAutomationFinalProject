package testautomation.UItests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testautomation.Base.BaseTest;

public class SearchProductTest extends BaseTest {
    @Test
    public void ValidateHomePage() {

        WebElement element = driver.findElement((By.xpath("//h2[text()='Features Items']")));
        Assert.assertTrue(element.isDisplayed());
    }

}
