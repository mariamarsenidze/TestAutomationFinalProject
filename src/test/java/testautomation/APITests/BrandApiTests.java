package testautomation.APITests;
import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("Final Project API")
@Feature("Brand Operations")
public class BrandApiTests {

    private final String baseUri = "https://automationexercise.com/api";

    @Test(priority = 1, description = "API 3: Get All Brands List")
    @Severity(SeverityLevel.BLOCKER)
    @Description("ყველა ბრენდის სიის წამოღება და შემოწმება")
    public void getAllBrandsList() {
        Response response = Allure.step("გაიგზავნოს GET მოთხოვნა ბრენდების სიის მისაღებად", () ->
                given()
                        .filter(new AllureRestAssured())
                        .get(baseUri + "/brandsList")
        );

        Allure.step("პასუხის ვალიდაცია: სტატუს კოდი 200 და ბრენდების სიის შემოწმება", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 200, "Response code mismatch!");
            Assert.assertNotNull(jsonResponse.get("brands"), "Brands list is null!");
            Assert.assertTrue(jsonResponse.getList("brands").size() > 0, "ბრენდების სია ცარიელია!");
        });
    }

    @Test(priority = 2, description = "API 4: PUT To All Brands List")
    @Severity(SeverityLevel.NORMAL)
    @Description("PUT მეთოდის აკრძალვის ვალიდაცია ბრენდების სიაზე")
    public void putToAllBrandsList() {
        Response response = Allure.step("გაიგზავნოს დაუშვებელი PUT მოთხოვნა ბრენდების სიაზე", () ->
                given()
                        .filter(new AllureRestAssured())
                        .put(baseUri + "/brandsList")
        );

        Allure.step("ვალიდაცია: შემოწმდეს 405 (Method Not Allowed) კოდი და შეტყობინება", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 405, "Should return 405 for PUT method");
            Assert.assertEquals(jsonResponse.getString("message"), "This request method is not supported.");
        });
    }
}