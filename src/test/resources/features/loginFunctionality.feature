Feature: CicekSepeti login functionality test with Positive, Negative and Boundary Value

  Background:
    Given user navigates to the login page

  #Kullanıcının doğru email ve password ile başarılı bir şekilde giriş yapabildiğini test ettim.
  @positive
  Scenario: Authorized users able to login
    Given user fills the email box as "email_valid" and password box as "password_valid"
    And page title should be "basePageTitle"
    Then user log out successfully

  #Kullanıcı yanlış email veya şifre ile giriş yapamayıp, beklenilen hata mesajını almasını test ettim.
  @negative
  Scenario Outline: Unauthorized users should not able to login
    Given user fills the email box as "<email>" and password box as "<password>"
    Then user should get error message as "E-mail address or password is incorrect. Please check your information and try again."
    Examples:
      |email                   |password         |
      |email_valid             |password_wrong   |
      |email_wrong             |password_valid   |

  #Kullanıcı email veya password alanını boş bıraktığında gerekli uyarı mesajını mesajını aldığını test ettim.
  @negative
  Scenario Outline: Users should get blank warning message while sign in with blank email or password
    Given user fills the email box as "<email>" and password box as "<password>"
    Then user should get error message as "Required field."
    Examples:
    |email      |password      |
    |email_valid|blank         |
    |blank      |password_valid|

   #Kullanıcının geçersiz formatlar girdiğinde, gerekli uyarı mesajını aldığını test ettim.
   #Gerekliliği bilmediğimden her seferinde browser çalıştırarak test ettim.
   @negative
    Scenario Outline: User should not able to enter invalid format for email box
    Given user fills the email box as "<email>" and password box as "<password>"
    Then user should get error message as "Please enter a valid e-mail address."
    Examples:
    |email           |password      |
    |email_invalid_1 |password_valid|
    |email_invalid_2 |password_valid|
    |email_invalid_3 |password_valid|
    |email_invalid_4 |password_valid|
    |email_invalid_5 |password_valid|
    |email_invalid_6 |password_valid|
    |email_invalid_7 |password_valid|
    |email_invalid_8 |password_valid|
    |email_invalid_9 |password_valid|
    |email_invalid_10|password_valid|
    |email_invalid_11|password_valid|
    |email_invalid_12|password_valid|
    |email_invalid_13|password_valid|

  #Kullanıcının email karakter sınırını aşması durumunda ki uyarıyı Boundary Value Analysis yöntemi ile test ettim.
  @boundary
  Scenario Outline: User able to get boundary error if email length more than 100 characters
    Given user fills the email box as "<email>" and password box as "<password>"
    Then user should get boundary error message as "'Email' must be between 0 and 100 characters." message if email is not between 0 to 100
    Examples:
    |email               |password      |
    |email_101_characters|password_valid|
    |email_100_characters|password_valid|
    |email_99_characters |password_valid|

  #Kullanıcının belirlenen password karakter sınırı dışında ki durumlarda uyarı mesajı almasını Boundary Value Analysis yöntemi ile test ettim.
  @boundar
  Scenario Outline: User should able to get boundary error if password length is not between 3 to 20 characters
    Given user fills the email box as "<email>" and password box as "<password>"
    Then user should get boundary error message as "Please enter minimum 3 and maximum 20 characters." message if email is not between 3 to 20
    Examples:
      |email      |password               |
      |email_valid|password_2_characters  |
      |email_valid|password_3_characters  |
      |email_valid|password_4_characters  |
      |email_valid|password_19_characters |
      |email_valid|password_20_characters |
      |email_valid|password_21_characters |


















