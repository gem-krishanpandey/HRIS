Feature: HRIS -> Onboarding

  Background: User Login into the HRIS Application
    When User clicks on Login Button
    Then User enters the "username"
    Then User enters the "password"
    And User logins into the application
    Then Verify user is logged into the application or not

  Scenario Outline: Search functionality
    When User clicks on Search Bar
    Then User enters "<employee name>"
    Then User verifies if "<employee name>" is present
    Examples:
      | employee name |
      |test         |

