Feature: Basket Functionality

  Background:
    Given user navigates to the main page

  @positive
  #Following the task description directly
  Scenario: User able to use basket functionality correctly
    Given user able to search "bilgisayar" on search box
    And user able to move to "2" page
    Then the page number should be correct
    And user able to click on a product
    Then user able to add product to basket
    And verifying that page product price and basket price should be same
    Then user able to improve amount of product as "2"
    And user able to delete product from basket
    Then verifying that basket has empty message as "Sepetinizde ürün bulunmamaktadır."



