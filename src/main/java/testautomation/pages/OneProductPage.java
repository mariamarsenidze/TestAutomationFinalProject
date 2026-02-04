package testautomation.pages;

import org.openqa.selenium.By;

public class OneProductPage {
    public By fillName = By.id("name");
    public By fillEmail = By.id("email");
    public By reviewText = By.id("review");
    public By submitReview = By.id("button-review");
    public By thankYouText = By.xpath("//span[text()='Thank you for your review.']");
}