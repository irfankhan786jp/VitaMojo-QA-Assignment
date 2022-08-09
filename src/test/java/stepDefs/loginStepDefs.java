package stepDefs;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import page.LoginPage;
import page.MainPage;

import java.io.File;
import java.io.IOException;

import static utils.WebDriverUtils.setDriver;

public class loginStepDefs {
    LoginPage loginPage = new LoginPage(setDriver());
    MainPage mainPage = new MainPage(setDriver());
    Response resp;
    ObjectMapper mapper = new ObjectMapper();
    String loginRequest="";
    JsonNode node;

    @When("User enters login details")
    public void user_enters_login_details() {
        loginPage.inputEmailTextBox("irfankhan786jp@gmail.com");
        loginPage.inputPasswordTextBox("");
        loginPage.clickLoginPageLoginButton();
    }

    @Then("User is successfully logged in")
    public void user_is_successfully_logged_in() {

    }

    @Given("User logins VMOS application with {string} and {string}")
    public void user_logins_vmos_application_with_and(String name, String email) throws IOException {
        node = mapper.readTree(new File("C:\\Users\\irfan\\Downloads\\Vita Mojo Demo\\src\\test\\resources\\requests\\loginRequest.json"));
//        ((ObjectNode) node).put("firstName", name);
        ((ObjectNode) node).put("email", email);
        ((ObjectNode) node).put("password", "");
        loginRequest = mapper.writeValueAsString(node);
        System.out.println(loginRequest);

    }
    @When("User inputs credentials")
    public void user_inputs_credentials() {
        RequestSpecification spec = RestAssured.given();
        resp = spec
                .baseUri("https://vmos2.vmos-demo.com/user")
                .basePath("/v1/auth")
                .body(node.toPrettyString())
                .when()
                .post()
                .thenReturn();
        System.out.println(resp.asString());

    }
    @Then("User gets successfully logged in")
    public void user_gets_successfully_logged_in() {
        Assert.assertEquals(resp.getStatusCode(), 201);
        Assert.assertEquals(JsonPath.from(resp.asString()).get("user.email"), "irfankhan786jp@gmail.com");
    }
}
