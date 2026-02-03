package testautomation.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import testautomation.steps.*;


import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    WebDriverWait wait;
    protected RegisterSteps registerSteps;
    protected LoginSteps loginSteps;
    protected ProductSteps productSteps;
    protected CartSteps cartSteps;
    protected HomeSteps homeSteps;
    protected ContactSteps contactSteps;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/");

        registerSteps = new RegisterSteps(driver);
        loginSteps = new LoginSteps(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
        homeSteps = new HomeSteps(driver);
        contactSteps = new ContactSteps(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}