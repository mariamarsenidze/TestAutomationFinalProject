package testautomation.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.RegisterPage;

import java.time.Duration;

public class RegisterSteps {

        private WebDriver driver;
        private WebDriverWait wait;
        private RegisterPage registerPage;

        public RegisterSteps(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            this.registerPage = new RegisterPage();

        }









}



