@testing
Feature: SauceLab Login


  Scenario Outline: : Send a request message via Obss contact page
    Given user navigates to sauceLab login page
    When user try to login with "<username>"  and "<password>"
    Then user verifies that successfully logged in
    Examples:
      | username        | password     |
      | standard_user   | secret_sauce |
      | locked_out_user | secret_sauce |
      | problem_user    | secret_sauce |