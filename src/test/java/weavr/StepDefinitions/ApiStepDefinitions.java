package weavr.StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import weavr.Utilities.ConfigurationReader;
import weavr.Utilities.apiWeavrMethods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiStepDefinitions {

    public String globalURI;
    public Response globalResponse;
    public JsonPath globalJsonPath;
    public String globalID;
    public List<List<String>> globalList;
    public String bearerToken= ConfigurationReader.get("bearerToken");

    @Given("Sending get request to related API as {string} with end point as {string}")
    public void sending_get_request_to_related_api_with_path_as(String apiURI,String endPoint) {

        //Typical get method. I could make it dynamic but for that I need to know Company culture more.
        globalURI=apiURI;
        RestAssured.baseURI=globalURI;
        Response response = RestAssured
                .given().accept(ContentType.JSON)
                .get(endPoint);
        globalResponse=response;
    }

    @Given("Sending post request to related API as {string} with end point as {string}")
    public void sending_post_request_to_related_api_with_path_as(String apiURI, String endPoint, DataTable dataTable) {

        //I use DataTable and I pass parameters into the Map with method for serialization. It can be more dynamic.
        List<List<String>> bodyList = dataTable.cells();

        //We make our input for body dynamic. We can directly write in Scenario steps our inputs.
        Map<String,Object> bodyMap = apiWeavrMethods.bodyMap(bodyList.get(1).get(0),bodyList.get(1).get(1),bodyList.get(1).get(2),bodyList.get(1).get(3));

        //We define our DataTable as global so in the next steps we can use it for verifications.
        globalList=bodyList;

        //We could create a dynamic method but for understanding better, I implemented post method here.
        globalURI=apiURI+endPoint;
        RestAssured.baseURI=globalURI;
        Response responsePost = RestAssured
                .given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .header("Authorization",bearerToken)
                .body(bodyMap)
                .post();


        //If we want to use response body for post, I define as global.
        globalResponse=responsePost;

        //Post method giving ID automatically, so I can use this ID in the next steps for verification and manipulation. I pass id parameter to the next steps.
        globalID= responsePost.path("id").toString();

        //OUTPUT FOR UNDERSTANDING STEPS
        System.out.println("---------CHECKING POST RESPONSE----------");
        System.out.println("Status Code: " + responsePost.statusCode());
        responsePost.prettyPrint();

    }

    //
    @Given("Verifying that content type is JSON")
    public void i_verify_that_content_type_is_json() {
        Assert.assertEquals(globalResponse.contentType(),"application/json; charset=utf-8");
    }

    @Given("Verifying that status code is {int}")
    public void i_verify_that_status_code_is(Integer expectedStatusCode) {
        Assert.assertEquals(globalResponse.statusCode(),expectedStatusCode);
    }

    @And("Verifying that created user exist in body with correct credentials")
    public void iVerifyThatCreatedUserExistInBodyWithCorrectCredentials() {
        RestAssured.baseURI=globalURI;
        Response responseGET = RestAssured
                .given().accept(ContentType.JSON)
                .and().pathParam("id",globalID)
                .header("Authorization",bearerToken)
                .when().get("/{id}");

        //Verify that whatever I post to API, it should be there as I posted
        Assert.assertEquals(responseGET.path("name"),globalList.get(1).get(0));
        Assert.assertEquals(responseGET.path("email"),globalList.get(1).get(1));
        Assert.assertEquals(responseGET.path("gender"),globalList.get(1).get(2));
        Assert.assertEquals(responseGET.path("status"),globalList.get(1).get(3));


        //OUTPUT FOR UNDERSTANDING STEPS
        System.out.println("\n\n\n----------GET RESPONSE BODY-----------");
        System.out.println("Status Code: " +responseGET.statusCode());
        responseGET.prettyPrint();
    }

    @Then("Sending delete request for created body data")
    public void sendingDeleteRequestForCreatedBodyData() {
        RestAssured.baseURI=globalURI;
        Response responseDelete = RestAssured
                .given().pathParam("id",globalID)
                .header("Authorization",bearerToken)
                .delete("/{id}");

        //Verifying that response body should be 204:No content
        Assert.assertEquals(responseDelete.statusCode(),204);
        System.out.println("\n\n\n---------SENDING DELETE REQUEST----------");
        System.out.println("Status Code: " +responseDelete.statusCode());
        responseDelete.prettyPrint();

    }


    @Then("Verifying that deleted data does not exist with {int} status code")
    public void verifyingThatDeletedDataDoesNotExistWithStatusCode(int expectedStatusCode) {

        //Verifying that deleted data should not be there anymore. Before I store posted response ID as global in post step for passing here.
        RestAssured.baseURI=globalURI;
        Response responseVerify = RestAssured
                .given().pathParam("id",globalID)
                .header("Authorization",bearerToken)
                .get("/{id}");

        //Verifying that after send Delete request, deleted response body should not be there and I should get be 404:Not Found
        Assert.assertEquals(responseVerify.statusCode(),expectedStatusCode);

        //OUTPUT FOR UNDERSTANDING STEPS
        System.out.println("\n\n\n---------CHECKING DELETED DATA----------");
        System.out.println("Status Code: " +responseVerify.statusCode());
        responseVerify.prettyPrint();
    }
}
