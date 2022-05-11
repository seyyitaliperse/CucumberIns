Feature: Login functionality with Negative, Positive and Boundary Value


  @positive
  Scenario: Authorized users able to login
    Given user login with email "valid_username" and password "valid_password"
    And page title should be "basePageTitle"
    Then user log out successfully

  @negative
  Scenario Outline: Users should get blank warning message while sign in with blank email or password
    Given user sing in with invalid email "<email>" or password "<password>"
    Then user should get blank "Required field." warning message
    Examples:
    |email      |password      |
    |valid_email|blank         |
    |blank      |valid_password|

  @negative
  Scenario Outline: Unauthorized users should not able to login
    Given user sing in with invalid email "<email>" or password "<password>"
    Then user should get wrong email or password error message "E-mail address or password is incorrect. Please check your information and try again."

    Examples:
    |email                   |password         |
    |valid_email             |invalid_password |
    |invalid_email           |valid_password   |

  @boundary
  Scenario: User able to see boundary error if enter more than 99 character for email box
    Given user sing in with invalid email "<email>" or password "<password>"
    Then user should get boundary error message
















