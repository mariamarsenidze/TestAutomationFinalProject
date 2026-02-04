package testautomation.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.ContactPage;

import java.io.File;
import java.io.FileWriter;
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

    @Step("Open Contact Us page")
    public void openContactUs() {
        driver.findElement(contactPage.contactUsButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                contactPage.getInTouchText));
    }

    @Step("Fill contact form with name: {name}, email: {email}, subject: {subject}")
    public void fillContactForm(
            String name,
            String email,
            String subject,
            String message
    ) {
        driver.findElement(contactPage.nameInput).sendKeys(name);
        driver.findElement(contactPage.emailInput).sendKeys(email);
        driver.findElement(contactPage.subjectInput).sendKeys(subject);
        driver.findElement(contactPage.messageInput).sendKeys(message);
    }

    @Step("Create temporary file for upload")
    public String createTempFile() {
        try {
            File file = File.createTempFile("upload", ".txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Test file");
            writer.close();
            return file.getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Upload file: {filePath}")
    public void uploadFile(String filePath) {
        driver.findElement(contactPage.uploadFileInput)
                .sendKeys(filePath);
    }

    @Step("Submit contact form and accept alert")
    public void submitFormAndAcceptAlert() {
        driver.findElement(contactPage.submitButton).click();
        driver.switchTo().alert().accept();
    }

    @Step("Verify success message is displayed")
    public boolean isSuccessMessageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        contactPage.successMessage
                )
        ).isDisplayed();
    }

    @Step("Click Home button using JavaScript")
    public void clickHomeButton() {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                driver.findElement(contactPage.homeButton)
        );
    }
}
