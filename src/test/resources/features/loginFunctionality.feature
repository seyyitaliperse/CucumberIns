Feature: Cicek Sepeti login functionality test with Negative, Positive and Boundary Value

  @positive
  Scenario: Authorized users able to login
    Given user enter valid email "email_valid" and password "password_valid" for sign in
    And page title should be "basePageTitle"
    Then user log out successfully

  @negative
  Scenario Outline: Users should get blank warning message while sign in with blank email or password
    Given user enter invalid email "<email>" or password "<password>" for sign in
    Then user should get blank "Required field." warning message
    Examples:
    |email      |password      |
    |email_valid|blank         |
    |blank      |password_valid|

  @negative
    Scenario: User should not able to enter invalid format for email box
    Given user enter invalid email "<email>" or password "<password>" for sign in
    Example:
      |email|password|
      |email_invalid_1|password_valid|

  @negative
  Scenario Outline: Unauthorized users should not able to login
    Given user enter invalid email "<email>" or password "<password>" for sign in
    Then user should get wrong email or password error message "E-mail address or password is incorrect. Please check your information and try again."

    Examples:
    |email                   |password         |
    |email_valid             |password_wrong   |
    |email_wrong             |password_valid   |

  @boundary
  Scenario Outline: User able to get boundary error if email length more than 100 characters
    Given user enter invalid email "<email>" or password "<password>" for sign in
    Then user should get email boundary error "'Email' must be between 0 and 100 characters." message if email has more than 100 character
    Examples:
    |email               |password      |
    |email_101_characters|password_valid|
    |email_100_characters|password_valid|
    |email_99_characters |password_valid|

  @boundary
  Scenario Outline: User should able to get boundary error if password length is not between 3 to 20 characters
    Given user enter invalid email "<email>" or password "<password>" for sign in
    Then user should get password boundary error "Please enter minimum 3 and maximum 20 characters." message if email is not between 3 to 20
    Examples:
      |email      |password               |
      |email_valid|password_2_characters  |
      |email_valid|password_3_characters  |
      |email_valid|password_4_characters  |
      |email_valid|password_19_characters |
      |email_valid|password_20_characters |
      |email_valid|password_21_characters |


















