package testautomation.pages;

import org.openqa.selenium.By;

public class HomePage {
    public By loginButton = By.xpath("//a[@href='/login']");
    public By logOutButton = By.xpath("//a[@href='/logout']");
    public By deleteAccountBtn = By.xpath("//a[@href='/delete_account']");
    public By productButton =  By.xpath("//a[@href='/products']");
    public By cartBtn = By.xpath("//a[@href='/view_cart']");
    public By validateHomeText = By.xpath("//h2[text()='Features Items']");




}
