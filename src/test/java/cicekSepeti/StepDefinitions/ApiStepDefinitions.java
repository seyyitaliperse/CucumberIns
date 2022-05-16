package cicekSepeti.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

public class ApiStepDefinitions {

    String globalURI="https://2c9889a3-719f-4417-ba0a-2938d8eab343.mock.pstmn.io";
    Response globalResponse;
    JsonPath globalJsonPath;


    @Given("I logged in related API with path as {string}")
    public void i_logged_in_related_api_with_path_as(String path) {
    RestAssured.baseURI=globalURI;
        Response response = RestAssured
                .given().accept(ContentType.HTML)
                .and().pathParam("path",path)
                .when().get("/test/{path}");
        globalResponse=response;
    }

    @Given("I verify that content type is HTML")
    public void i_verify_that_content_type_is_html() {
        Assert.assertEquals(globalResponse.contentType(),"text/html; charset=utf-8");
    }

    @Given("I verify that status code is {int}")
    public void i_verify_that_status_code_is(Integer expectedStatusCode) {
        Assert.assertEquals(globalResponse.statusCode(),expectedStatusCode);
    }

    @Then("I convert response to JSON")
    public void i_convert_response_to_json() {
        JsonPath jsonPath = globalResponse.jsonPath();
        globalJsonPath=jsonPath;

    }
    @Then("I get list of installment products")
    public void i_get_list_of_installment_products() {
        List<String> productList = globalJsonPath.getList("result.data.products.name");

        //Örneklendirmek için
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i));
        }
    }


    @Given("I logged in related API with query parameter {string} with {string}")
    public void iLoggedInRelatedAPIWithQueryParameterWith(String key, String value) {
        RestAssured.baseURI=globalURI;
        Response response = RestAssured
                .given().accept(ContentType.HTML)
                .and().queryParam(key,value)
                .when().get("/test/");
        globalResponse=response;
    }
}
