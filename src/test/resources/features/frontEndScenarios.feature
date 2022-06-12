Feature: Basket Functionality

  Background:
    Given user navigates to the main page

  @positive
  #Following the task description directly
  Scenario: User able to use basket functionality correctly
    Given user search for "bilgisayar" on search engine
    And   user navigate to page "2" on listed product page
    Then  the page number should be correct
    And   user clicks on a random product then adds to basket
    Then  user navigates to basket module
    And   verifying that page product price and basket price should be same
    Then  user improves amount of product as "2"
    And   user deletes product from basket
    Then  verifying that basket has empty message as "Sepetinizde ürün bulunmamaktadır."



