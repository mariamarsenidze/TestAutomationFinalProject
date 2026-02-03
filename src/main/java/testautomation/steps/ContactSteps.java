package testautomation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.ContactPage;
import testautomation.pages.RegisterPage;

import java.time.Duration;

public class ContactSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private ContactPage contactPage;

    public ContactSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.contactPage = new ContactPage();

    }

}
