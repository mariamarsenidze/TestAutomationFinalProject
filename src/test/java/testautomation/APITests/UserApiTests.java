package testautomation.APITests;


import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Epic("Final Project API")
@Feature("Login Operations")
public class UserApiTests {

    private final String baseUri = "https://automationexercise.com/api";

    @Test(priority = 1, description = "API 7: POST To Verify Login with valid details")
    @Severity(SeverityLevel.BLOCKER)
    @Description("ვალიდური ლოგინის შემოწმება")
    public void postVerifyLoginValid() {
        // Step 1: Request გაგზავნა
        Response response = Allure.step("გაიგზავნოს POST მოთხოვნა ვალიდური მონაცემებით", () ->
                given()
                        .filter(new AllureRestAssured()) // ეს უზრუნველყოფს Request/Response ატაჩმენტებს
                        .formParam("email", "tester123@gmail.com")
                        .formParam("password", "test1234")
                        .post(baseUri + "/verifyLogin")
        );

        // Step 2: ვალიდაცია
        Allure.step("პასუხის ვალიდაცია: შემოწმდეს responseCode", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertNotNull(jsonResponse.get("responseCode"), "Response code არ უნდა იყოს ცარიელი");
        });
    }

    @Test(priority = 2, description = "API 8: POST To Verify Login without email parameter")
    @Severity(SeverityLevel.CRITICAL)
    @Description("ლოგინი მეილის გარეშე - 400 შეცდომის ვალიდაცია")
    public void postVerifyLoginWithoutEmail() {
        Response response = Allure.step("გაიგზავნოს POST მოთხოვნა მხოლოდ პაროლით (Email-ის გარეშე)", () ->
                given()
                        .filter(new AllureRestAssured())
                        .formParam("password", "test1234")
                        .post(baseUri + "/verifyLogin")
        );

        Allure.step("შეცდომის კოდის (400) და მესიჯის ვალიდაცია", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 400);
            Assert.assertEquals(jsonResponse.getString("message"), "Bad request, email or password parameter is missing in POST request.");
        });
    }

    @Test(priority = 3, description = "API 9: DELETE To Verify Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("DELETE მეთოდის აკრძალვის შემოწმება ლოგინის ენდპოინტზე")
    public void deleteVerifyLogin() {
        Response response = Allure.step("გაიგზავნოს DELETE მოთხოვნა verifyLogin მისამართზე", () ->
                given()
                        .filter(new AllureRestAssured())
                        .delete(baseUri + "/verifyLogin")
        );

        Allure.step("ვალიდაცია: მეთოდი არ უნდა იყოს დაშვებული (405)", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 405);
            Assert.assertEquals(jsonResponse.getString("message"), "This request method is not supported.");
        });
    }

    @Test(priority = 4, description = "API 10: POST To Verify Login with invalid details")
    @Severity(SeverityLevel.NORMAL)
    @Description("ლოგინი არასწორი მონაცემებით - 404 შეცდომის ვალიდაცია")
    public void postVerifyLoginInvalid() {
        Response response = Allure.step("გაიგზავნოს POST მოთხოვნა არარსებული მომხმარებლის მონაცემებით", () ->
                given()
                        .filter(new AllureRestAssured())
                        .formParam("email", "nonexistent_user_999@test.com")
                        .formParam("password", "wrongpassword")
                        .post(baseUri + "/verifyLogin")
        );

        Allure.step("ვალიდაცია: მომხმარებელი არ უნდა მოიძებნოს (404)", () -> {
            JsonPath jsonResponse = new JsonPath(response.asString());
            Assert.assertEquals(jsonResponse.getInt("responseCode"), 404);
            Assert.assertEquals(jsonResponse.getString("message"), "User not found!");
        });
    }
}