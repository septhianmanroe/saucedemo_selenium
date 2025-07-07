Feature: User Authentication Functionality

  Scenario: TC001 - Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    And I press the login button
    Then I will be redirected to the products page

  Scenario: TC007 - Successful logout from the application
    Given I am logged into the application
    When I press the logout button
    Then I will be redirected back to the login page