
package testautomation.pages;

import org.openqa.selenium.By;

public class ContactPage {

    public By contactUsButton = By.xpath("//a[text()=' Contact us']");
    public By getInTouchText = By.xpath("//h2[text()='Get In Touch']");

    public By nameInput = By.name("name");
    public By emailInput = By.name("email");
    public By subjectInput = By.name("subject");
    public By messageInput = By.id("message");

    public By uploadFileInput = By.name("upload_file");
    public By submitButton = By.name("submit");

    public By successMessage =
            By.xpath("//div[@class='status alert alert-success']");

    public By homeButton = By.xpath("//a[text()=' Home']");
}
