package testautomation.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testautomation.steps.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected RegisterSteps registerSteps;
    protected LoginSteps loginSteps;
    protected ProductSteps productSteps;
    protected CartSteps cartSteps;
    protected HomeSteps homeSteps;
    protected ContactSteps contactSteps;
    protected OneProductSteps oneProductSteps;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://automationexercise.com/");

        removeGoogleAds();

        registerSteps = new RegisterSteps(driver);
        loginSteps = new LoginSteps(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
        homeSteps = new HomeSteps(driver);
        contactSteps = new ContactSteps(driver);
        oneProductSteps=new OneProductSteps(driver);
    }


    protected void removeGoogleAds() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "var ads = document.querySelectorAll('ins.adsbygoogle, #aswift_0_host, #aswift_0_expand, .google-auto-placed');" +
                            "for (var i = 0; i < ads.length; i++) { ads[i].remove(); }"
            );
        } catch (Exception e) {
            System.out.println("რეკლამების წაშლისას დაფიქსირდა შეცდომა: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}