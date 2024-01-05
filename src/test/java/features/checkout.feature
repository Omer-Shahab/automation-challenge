Feature: Login Feature Of SourceDemo Website

  Scenario Outline: Check login is ddd with valid credentials
  Given User open the browser and navigate to sourcedemo
  When User is on login page
  Then User enters valid username "<username>" and password "<password>"
  And Clicks on Login Button
  Then User is navigated to home page
  And User select a product named "Sauce Labs Bike Light"
  And User add the product to the cart
  And User go to the cart
  And User proceed to checkout
  And User enter the following checkout information:
  | First Name | Last Name | Zip Code |
  | MyName     | Testing   | 775500   |
  And User continue with the checkout
  And User complete the order
  Then User should see a confirmation message "THANK YOU FOR YOUR ORDER"
  And Close the browser
  Examples:
  | username      | password     |
  | standard_user | secret_sauce |

  Scenario Outline: Unsuccessful Shopping
    Given User open the browser and navigate to sourcedemo
    When User is on login page
    Then User enters valid username "<username>" and password "<password>"
    And Clicks on Login Button
    Then User is navigated to home page
    And User select a product named "Invalid Product"
    And Close the browser
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |