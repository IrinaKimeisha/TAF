Feature: Login

  Scenario: successful login
    Given general user with correct credentials
    And open the login page
    When user enters correct credentials and click login button
    Then user passes to Dashboard page