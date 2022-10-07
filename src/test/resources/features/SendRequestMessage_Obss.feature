Feature: Sending request message to Obss Company

  Background: User navigates to obss website
    Given user on the obss base page

  Scenario: Send a request message via Obss contact page
    Given user navigates to obss contact page
    When user send a request message to obss
      | Full Name    | Email Adress          | Phone Number | Message     |
      | Thor Odinson | thorodinson@gmail.com | 1522821351   | Hello! Obss |
    Then user verifies that successfully get feedback message