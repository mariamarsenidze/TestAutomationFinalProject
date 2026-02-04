package testautomation.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testautomation.pages.ProductPage;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private ProductPage productPage;

    public ProductSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.productPage = new ProductPage();
    }

    @Step("Search for product: {productName}")
    public ProductSteps inputProduct(String productName) {
        WebElement productInput = wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.searchInput));
        productInput.sendKeys(productName);
        return this;
    }

    @Step("Click on search button")
    public ProductSteps clickSearch() {
        driver.findElement(productPage.searchButton).click();
        return this;
    }

    @Step("Add product at index {index} to cart")
    public void addProductToCart(int index) {
        List<WebElement> products = driver.findElements(productPage.productsList);

        WebElement product = products.get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        WebElement addToCart = product.findElement(By.xpath(".//a[@data-product-id]"));

        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
    }

    @Step("Click on 'Continue Shopping' button")
    public void clickContinueShopping() {
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(productPage.continueShoppingButton)
        );
        button.click();
    }

    @Step("Verify that products section is displayed")
    public boolean isProductDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.productsText)).isDisplayed();
    }

    @Step("Verify that searched products title is displayed")
    public boolean isSearchedProductDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.searchedProductsTitle)).isDisplayed();
    }

    @Step("Get count of searched products")
    public int getProductsCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPage.searchedProductsList)).size();
    }

    @Step("Verify if review section is visible")
    public boolean isReviewVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPage.reviewText)).isDisplayed();
    }

    @Step("Click on a random 'View Product' button")
    public ProductSteps clickRandomViewProduct() {
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productPage.viewProductButton));

        Random random = new Random();
        int randomIndex = random.nextInt(buttons.size());

        WebElement randomButton = buttons.get(randomIndex);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomButton);
        return this;
    }
}