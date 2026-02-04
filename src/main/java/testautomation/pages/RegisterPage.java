package testautomation.pages;

import org.openqa.selenium.By;

public class RegisterPage {

    public By signupLoginBtn = By.xpath("//a[text()=' Signup / Login']");

    public By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    public By nameInput = By.cssSelector("input[data-qa='signup-name']");
    public By emailInput = By.cssSelector("input[data-qa='signup-email']");
    public By signupButton = By.cssSelector("button[data-qa='signup-button']");

    public By enterAccountInfoText = By.xpath("//b[text()='Enter Account Information']");
    public By titleMrsRadio = By.id("id_gender2");
    public By passwordInput = By.id("password");
    public By daysDropdown = By.id("days");
    public By monthsDropdown = By.id("months");
    public By yearsDropdown = By.id("years");

    public By newsletterCheckbox = By.id("newsletter");
    public By offersCheckbox = By.id("optin");


    public By firstNameInput = By.id("first_name");
    public By lastNameInput = By.id("last_name");
    public By companyInput = By.id("company");
    public By address1Input = By.id("address1");
    public By address2Input = By.id("address2");
    public By countryDropdown = By.id("country");
    public By stateInput = By.id("state");
    public By cityInput = By.id("city");
    public By zipcodeInput = By.id("zipcode");
    public By mobileInput = By.id("mobile_number");

    public By createAccountBtn = By.cssSelector("button[data-qa='create-account']");


    public By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    public By continueBtn = By.cssSelector("a[data-qa='continue-button']");

    public By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");


    public By deleteAccountBtn = By.xpath("//a[text()=' Delete Account']");
    public By accountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    public By continueDeleteBtn = By.cssSelector("a[data-qa='continue-button']");

    //5
    public By emailAlreadyExistText = By.xpath("//*[contains(text(),'already exist')]");
}