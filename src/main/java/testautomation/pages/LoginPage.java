package testautomation.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public By emailInput = By.cssSelector("input[data-qa='login-email']");
    public By passwordInput = By.cssSelector("input[data-qa='login-password']");
    public By submitButton =By.cssSelector("button[data-qa='login-button']");
    public By loginHeader = By.xpath("//h2[text()='Login to your account']");
    public By userLoggedIn = By.xpath("//li/a[contains(.,'Logged in as')]");
    public By deletedText = By.xpath("//h2[@data-qa='account-deleted']");
    public By incorrectEmailText =  By.xpath("//p[text()='Your email or password is incorrect!']");
}
