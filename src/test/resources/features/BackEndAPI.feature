Feature: Installment and no installment product list verification


  #I verify that basic funtions of URL
  @negative
  Scenario: Verify that end point is working properly
    Given Sending get request to related API as "https://gorest.co.in" with end point as "/public/v2/users"
    And   Verifying that content type is JSON
    And   Verifying that status code is 200


  #Create a user with POST
  #Verify data with GET
  #Delete data with DELETE
  @apiTest
  Scenario: Verify not installment product list with given API
    Given Sending post request to related API as "https://gorest.co.in" with end point as "/public/v2/users"
    |Name   |Email                    |Gender|Status|
    |WeavrIO|marvelssssweavr@gmail.com|male  |active|
    Then   Verifying that content type is JSON
    And  Verifying that status code is 201
    Then Verifying that created user exist in body with correct credentials
    And  Sending delete request for created body data
    Then Verifying that deleted data does not exist with 404 status code












