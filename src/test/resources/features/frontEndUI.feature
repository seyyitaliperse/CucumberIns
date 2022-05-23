Feature: Cart Functionality

  Background:
    Given user navigates to the login page

  #I tested login function with valid credentials
  @positive
  Scenario Outline: Authorized users able to login
    Given user login with username as "<username>" and password as "<password>"
    And page title should be "Swag Labs"
    Then user log out successfully
    Examples:
      |username                |password            |
      |standard_user           |   secret_sauce     |
      |problem_user            |   secret_sauce     |
      |performance_glitch_user |   secret_sauce     |

  #Kullanıcı yanlış email veya şifre ile giriş yapamayıp, beklenilen hata mesajını almasını test ettim.
  @negative
  Scenario: Unauthorized users should not able to login
    Given user fills the email box as "wrongUsername" and password box as "wrongPassword"
    Then user should get error message as "Epic sadface: Username and password do not match any user in this service"

  #I have used Data Table method her for understanding what kind of inputs I enter
  @positive
  Scenario: Authorized users able to buy item
  Given user login with username as "standard_user" and password as "secret_sauce"
  And user add some items to the chart
  Then user should able to go for check out
  And user fills out necessary inputs
  |First Name|Last Name|Zip Code|
  |Seyyit Ali|Perse    |48000   |
  Then user complete order and get successful message as "THANK YOU FOR YOUR ORDER"
  And user log out successfully
