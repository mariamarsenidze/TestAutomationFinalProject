package testautomation.pages;

import org.openqa.selenium.By;

public class ProductPage {
    public By searchInput = By.id("search_product");
    public By searchButton = By.id("submit_search");
    public By productsList = By.cssSelector(".product-image-wrapper");
    public By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    public By productsText = By.xpath("//h2[text()='All Products']");
    public By searchedProductsTitle =  By.xpath("//h2[text()='Searched Products']");
    public By searchedProductsList = By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");
    public By viewProductButton = By.xpath("//a[text()='View Product']");
    public By reviewText = By.xpath("//a[@href='#reviews']");

}
