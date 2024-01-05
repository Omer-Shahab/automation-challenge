Feature: Login Feature Of SourceDemo Website

  Scenario Outline: Check login is successful with valid credentials
    Given User open the browser and navigate to sourcedemo
    When User is on login page
    Then User enters valid username "<username>" and password "<password>"
    And Clicks on Login Button
    Then User is navigated to home page
    And Close the browser

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Check login is successful with invalid credentials
    Given User open the browser and navigate to sourcedemo
    When User is on login page
    Then User enters valid username "<username>" and password "<password>"
    And Clicks on Login Button
    Then User is not able to navigated to product page
    And Close the browser

    Examples:
      | username     | password         |
      | invalid_user | secret_sauce     |
      | invalid_user | invalid_password |
