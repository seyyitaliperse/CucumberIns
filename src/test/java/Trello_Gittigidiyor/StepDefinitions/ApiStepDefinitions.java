package Trello_Gittigidiyor.StepDefinitions;

import Trello_Gittigidiyor.Pages.BasePage;
import Trello_Gittigidiyor.Utilities.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import Trello_Gittigidiyor.Utilities.apiMethods_Seyyit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiStepDefinitions {

    public String globalURI;
    public Response globalResponse;
    public Response globalBoardResponse;
    public String globalBoardID;
    public Response globalListResponse;
    public String globalListID;
    public List<List<String>> globalList;
    public Map<String, Object> globalAuthorizationMap = apiMethods_Seyyit.authorizationMap();
    public Map<String,Object> cardIdMap = new HashMap<>();

    @Given("Creating board while sending post request to related API as {string} with end point as {string}")
    public void creating_board_while_sending_post_request_to_related_api_with_path_as(String apiURI, String endPoint, DataTable dataTable) {

        /**I use DataTable and I pass parameters into the Map with method for serialization. It can be more dynamic.
         */
        List<List<String>> bodyList = dataTable.cells();
        String name = bodyList.get(1).get(0);
        String defaultList = bodyList.get(1).get(1);
        String backgroundColor = bodyList.get(1).get(2);


        /**We make our input for body dynamic. We can directly write in Scenario steps our inputs.
         */
        Map<String, Object> boardMap = apiMethods_Seyyit.boardMap(name, defaultList, backgroundColor);

        /**We define our DataTable as global so in the next steps we can use it for verifications.
         *
         */
        globalList = bodyList;

        /**We could create a dynamic method but for understanding better, I implemented post method here.
         *
         */
        globalURI = apiURI + endPoint;
        RestAssured.baseURI = globalURI;
        Response postResponse = RestAssured
                .given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().queryParams(boardMap)
                .and().queryParams(globalAuthorizationMap)
                .post();


        /**If we want to use response body for post, I define as global.
         *
         */
        globalBoardResponse = postResponse;
        globalResponse = postResponse;

        /**Post method giving ID automatically, so I can use this ID in the next steps for verification and manipulation. I pass id parameter to the next steps.
         */
        globalBoardID = postResponse.path("id").toString();
        BrowserUtils.waitFor(10);

    }


    @Given("Verifying that content type is JSON and status code is {int}")
    public void i_verify_that_content_type_is_json(int expectedStatusCode) {
        Assert.assertEquals(globalResponse.contentType(), "application/json; charset=utf-8");
        Assert.assertEquals(globalResponse.statusCode(), expectedStatusCode);

    }


    @And("Verifying that created board is exist")
    public void iVerifyThatCreatedBoardExistWithCorrectCredentials() {
        RestAssured.baseURI = globalURI;
        Response getResponse = RestAssured
                .given().accept(ContentType.JSON)
                .and().pathParam("id", globalBoardID)
                .and().queryParams(globalAuthorizationMap)
                .when().get("/{id}");


    }

    @Given("Creating list while sending post request to related API as {string} with end point as {string}")
    public void creatingListWhileSendingPostRequestToRelatedAPIAsWithEndPointAs(String apiURI, String endPoint,DataTable dataTable) {
        BrowserUtils.waitFor(3);

        List<List<String>> bodyList = dataTable.cells();
        String name = bodyList.get(1).get(0);

        Map<String, Object> listMap = apiMethods_Seyyit.listMap(name, globalBoardID);


        globalURI = apiURI + endPoint;
        RestAssured.baseURI = globalURI;
        Response postResponse = RestAssured
                .given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().queryParams(listMap)
                .and().queryParams(globalAuthorizationMap)
                .post();

        globalListResponse = postResponse;
        globalListID = postResponse.path("id").toString();



    }

    @Given("Creating card while sending post request to related API as {string} with end point as {string}")
    public void creatingCardWhileSendingPostRequestToRelatedAPIAsWithEndPointAs(String apiURI, String endPoint, DataTable dataTable) {
        BrowserUtils.waitFor(5);

        List<List<String>> bodyList = dataTable.cells();
        String name = bodyList.get(1).get(0);
        String idList = globalListID;
        Map<String, Object> cardMap = apiMethods_Seyyit.cardsMap(name, idList);


        globalURI = apiURI + endPoint;
        RestAssured.baseURI = globalURI;
        Response postResponse = RestAssured
                .given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().queryParams(cardMap)
                .and().queryParam("locationName","Welcome to Sample Card")
                .and().queryParams(globalAuthorizationMap)
                .post();

        cardIdMap.put(name,postResponse.path("id"));



    }

    @Given("Updating random card while sending put request to related API as {string} with end point as {string}")
    public void updatingCardWhileSendingPutRequestToRelatedAPIAsWithEndPointAs(String apiURI, String endPoint,DataTable dataTable) {
        BrowserUtils.waitFor(3);

        /** I create one random number method in our abstract class "BasePage" and It will work dynamically depends how many cards we created.
         */
        String cardNum = String.valueOf(BasePage.randomNum(1,cardIdMap.size()));
        String randomCard = "Card_"+cardNum;
        List<List<String>> bodyList =dataTable.cells();
        String name = bodyList.get(1).get(0);

        globalURI = apiURI + endPoint;
        RestAssured.baseURI = globalURI;
        Response updateResponse = RestAssured
                .given().accept(ContentType.JSON)
                .pathParam("id",cardIdMap.get(randomCard))
                .and().queryParams(globalAuthorizationMap)
                .and().queryParams("name",name)
                .put("/{id}");
    }

    @Given("Deleting cards from the board while sending delete request to related API as {string} with end point as {string}")
    public void deletingCardFromTheBoardWhileSendingDeleteRequestToRelatedAPIAsWithEndPointAs(String apiURI, String endPoint) {

        /** How many cards we have on board it will delete dynamically all of them.
         */
        for(int i=1;i<=cardIdMap.size();i++){
            BrowserUtils.waitFor(3);

            globalURI = apiURI + endPoint;
            RestAssured.baseURI = globalURI;
            Response deleteResponse = RestAssured
                    .given().accept(ContentType.JSON)
                    .pathParam("id",cardIdMap.get("Card_"+i).toString())
                    .and().queryParams(globalAuthorizationMap)
                    .delete("/{id}");
        }
    }

    @Given("Deleting board from while sending delete request to related API as {string} with end point as {string}")
    public void deletingBoardFromWhileSendingDeleteRequestToRelatedAPIAsWithEndPointAs(String apiURI, String endPoint) {
        globalURI = apiURI + endPoint;
        RestAssured.baseURI = globalURI;
        Response deleteResponse = RestAssured
                .given().accept(ContentType.JSON)
                .pathParam("id",globalBoardID)
                .and().queryParams(globalAuthorizationMap)
                .delete("/{id}");

    }
}
