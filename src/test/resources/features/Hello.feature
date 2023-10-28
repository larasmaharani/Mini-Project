Feature: Hello
  As an Admin
  I want to see index API
  So that I can See the Result

  # [Positive] see Hello Endpoint with Correct Data
  Scenario: As admin I can see Hello Endpoint with Correct Data
    Given I set GET Hello Endpoint
    When I send GET Hello HTTP request
    Then I receive valid HTTP response code 200

  # [Negative] see Response Hello Endpoint with invalid URL
  Scenario: As admin I can't get response Hello Endpoint with invalid URL
    Given I set GET Hello Wrong Endpoint
    When I send GET Hello HTTP request invalid URL
    Then I receive valid HTTP response code 404

  # [Negative] Invalid Create new user
  Scenario: As an admin I can't create a new user with Hello using the POST method
    Given I set POST Hello Endpoint
    When I send POST Hello Endpoint Request
    Then I receive valid HTTP response code 405