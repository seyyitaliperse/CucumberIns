Feature: Verifying some http method results, status codes and

  #I verify that basic data of URL.
  @apiTest
  Scenario: Verify that end point is working properly
    Given Sending get request to related API as "https://gorest.co.in" with end point as "/public/v2/users"
    And   Verifying that content type is JSON
    And   Verifying that status code is 200


  #POST-GET-UPDATE-DELETE test in one Scenario. I can do separate without dynamic, but I think in this point we as a logic not necessary
  #From data table you can enter anything you want, It will be dynamic
  @apiTest
  Scenario: Verifying that POST, GET, UPDATE and DELETE methods working properly
    #POST
    Given Sending post request to related API as "https://gorest.co.in" with end point as "/public/v2/users"
    |Name          |Email                      |Gender|Status|
    |Doctor Strange|brandWatchStrange@gmail.com|male  |active|
    And  Verifying that content type is JSON
    And  Verifying that status code is 201
    #GET
    Then Verifying that created user exist in body with correct credentials
    #UPDATE
    And  Sending put request for existing body data
      |Name      |Email                        |Status  |
      |Thor      |brandWatchThor@gmail.com     |inactive|
    #DELETE
    And  Sending delete request for created body data
    Then Verifying that deleted data does not exist with 404 status code












