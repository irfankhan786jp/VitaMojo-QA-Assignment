package stepDefs;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import page.MainPage;
import page.RegistrationPage;
import utils.WebDriverUtils;

import java.io.File;
import java.io.IOException;

public class accountRegistrationStepDefs extends WebDriverUtils{
    RegistrationPage regPage = new RegistrationPage(setDriver());
    MainPage mainPage = new MainPage(setDriver());
    Response resp;
    ObjectMapper mapper = new ObjectMapper();
    String postRegistrationRequest="";

    @Given("User navigates to VMOS application")
    public void user_navigates_to_vmos_application() {
        mainPage.clickLoginButtonMainPage();

    }
    @When("User submits account details for creation")
    public void user_submits_account_details_for_creation() {
        regPage.clickCreateAccountTab();
        regPage.inputNameTextBox("Irfan");
        regPage.inputEmailTextBox("irfankhan786jp@gmail.com");
        regPage.inputPasswordTextBox("  ");
        regPage.clickCheckbox();
        regPage.clickCreateAccountButton();
    }
    @Then("User gets successfully created")
    public void user_gets_successfully_created() {

    }

    @Given("User open VMOS application with {string} and {string}")
    public void user_open_vmos_application(String name, String email) throws IOException {
        JsonNode node = mapper.readTree(new File("C:\\Users\\irfan\\Downloads\\Vita Mojo Demo\\src\\test\\resources\\requests\\registrationRequest.json"));
        ((ObjectNode) node).put("email", email);
        ((ObjectNode) node).put("password", "");
        JsonNode profileNode = ((ObjectNode) node).get("profile");
        ((ObjectNode) profileNode).put("firstName", name);

        postRegistrationRequest = mapper.writeValueAsString(node);

    }
    @When("User sends account details for creation")
    public void user_sends_account_details_for_creation() {
        RequestSpecification spec = RestAssured.given();
        resp = spec
                .baseUri("https://vmos2.vmos-demo.com/user")
                .basePath("/v1/user")
                .body(postRegistrationRequest)
                .when()
                .post()
                .thenReturn();
        System.out.println(resp.asString());
    }

    @Then("User gets successfully created via API")
    public void user_gets_successfully_created_via_api() {
        Assert.assertEquals(JsonPath.from(resp.asString()).get("statusCode"), 201);
    }
}
