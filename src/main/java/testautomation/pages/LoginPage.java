package testautomation.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public By emailInput = By.cssSelector("input[data-qa='login-email']");
    public By passwordInput = By.cssSelector("input[data-qa='login-password']");
    public By submitButton =By.cssSelector("button[data-qa='login-button']");
}
