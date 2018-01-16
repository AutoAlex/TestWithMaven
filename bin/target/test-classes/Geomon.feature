Feature: login

  @smoke1
  Scenario Outline: User can login with valid details
    Given User navigates the Login link from Ipass homepage
    And provides his email "<userid>" and password "<password>" and selects the LoginButton
    Then user should be logged in

    Examples:
      | userid   | password |
      | username | password |
