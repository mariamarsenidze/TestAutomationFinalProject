package testautomation.APITests;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("Final Project API")
@Feature("Product Operations")
public class ProductApiTests {

    private final String baseUri = "https://automationexercise.com/api";

    @Test(priority = 1, description = "API 1: Get All Products List")
    @Severity(SeverityLevel.BLOCKER)
    public void getAllProductsList() {
        Response response = Allure.step("გაიგზავნოს GET მოთხოვნა პროდუქტების სიის მისაღებად", () ->
                given()
                        .filter(new AllureRestAssured())
                        .get(baseUri + "/productsList")
        );

        Allure.step("პასუხის ვალიდაცია: სტატუს კოდი 200 და პროდუქტების არსებობა", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 200, "Response code mismatch!");
            Assert.assertNotNull(jsonResponse.get("products"), "Products list is null!");
        });
    }

    @Test(priority = 2, description = "API 2: POST To All Products List")
    @Severity(SeverityLevel.NORMAL)
    public void postToAllProductsList() {
        Response response = Allure.step("გაიგზავნოს დაუშვებელი POST მოთხოვნა პროდუქტების სიაზე", () ->
                given()
                        .filter(new AllureRestAssured())
                        .post(baseUri + "/productsList")
        );

        Allure.step("ვალიდაცია: შემოწმდეს 405 შეცდომა და შესაბამისი მესიჯი", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 405);
            Assert.assertEquals(jsonResponse.getString("message"), "This request method is not supported.");
        });
    }

    @Test(priority = 3, description = "API 5: POST To Search Product")
    @Severity(SeverityLevel.CRITICAL)
    public void postSearchProduct() {
        Response response = Allure.step("პროდუქტის ძებნა 'tshirt' პარამეტრით", () ->
                given()
                        .filter(new AllureRestAssured())
                        .formParam("search_product", "tshirt")
                        .post(baseUri + "/searchProduct")
        );

        Allure.step("ვალიდაცია: სტატუს კოდი 200 და ნაპოვნი პროდუქტების სია", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 200);
            Assert.assertTrue(jsonResponse.getList("products").size() > 0, "ძებნის შედეგი ცარიელია!");
        });
    }

    @Test(priority = 4, description = "API 6: POST To Search Product without parameter")
    @Severity(SeverityLevel.MINOR)
    public void postSearchProductWithoutParam() {
        Response response = Allure.step("ძებნის მოთხოვნა პარამეტრის გარეშე", () ->
                given()
                        .filter(new AllureRestAssured())
                        .post(baseUri + "/searchProduct")
        );

        Allure.step("ვალიდაცია: შემოწმდეს 400 (Bad Request) შეცდომა", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 400);
            Assert.assertEquals(jsonResponse.getString("message"), "Bad request, search_product parameter is missing in POST request.");
        });
    }
}