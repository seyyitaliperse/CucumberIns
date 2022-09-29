Feature: Verifying some http method results, status codes and


  #POST-GET-UPDATE-DELETE test in one Scenario. I can do separate without dynamic, but I think in this point we as a logic not necessary
  #From data table you can enter anything you want, It will be dynamic

  @apiTest
  Scenario: Verifying that POST, GET, UPDATE and DELETE methods working properly
    #CREATING BOARD --- POST
    Given Creating board while sending post request to related API as "https://api.trello.com" with end point as "/1/boards"
      |Name          |Default List                 |Background Color|
      |Board_1       |false                        |red             |
    And  Verifying that content type is JSON and status code is 200
    #VERFYING BOARD --- GET
    Then Verifying that created board is exist
    #CREATING LIST --- POST
    Given Creating list while sending post request to related API as "https://api.trello.com" with end point as "/1/list"
      |Name            |
      |List_1          |
    #CREATING CARDS --- POST
    #In this phase for dynamic coding I could write only one steps which create how many card we want to create and I could store all card id's in map but for better understanding I did not.
    Given Creating card while sending post request to related API as "https://api.trello.com" with end point as "/1/cards"
      |Name    |
      |Card_1  |
    Given Creating card while sending post request to related API as "https://api.trello.com" with end point as "/1/cards"
      |Name    |
      |Card_2  |
    #UPDATE RANDOM CARD --- PUT
    Given Updating random card while sending put request to related API as "https://api.trello.com" with end point as "/1/cards"
      |Name         |
      |Updated_Card |
    #DELETE CARD
    Given Deleting cards from the board while sending delete request to related API as "https://api.trello.com" with end point as "/1/cards"
    Given Deleting board from while sending delete request to related API as "https://api.trello.com" with end point as "/1/boards"