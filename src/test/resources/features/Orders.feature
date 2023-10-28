Feature: Order

  As a admin
  I want to order product
  So that I can manage products

  Scenario: As an admin, I can create new order with valid endpoint and valid body parameter and parameter value
    Given I POST create orders endpoints
    When I POST HTTP request for create orders with valid data
    And I receive response data for create orders
    Then I receive valid HTTP response 200 for create orders

  Scenario: As an admin, I can't create new order because endpoint is invalid
    Given I POST create orders endpoint
    When I POST HTTP request for create orders with invalid endpoint
    Then I receive HTTP response 404 for create orders

  Scenario: As an admin, I can't create anew order because body is empty
    Given I POST create orders endpoint url
    When I POST HTTP request for create orders with empty body
    Then I receive HTTP response 400 for create orders

  Scenario: As an admin, I can't create a new order without token
    Given I POST create orders endpoints url
    When I POST HTTP request for create orders without token
    Then I receive HTTP status 401 for create orders

  Scenario: As an admin, I can get all order with valid endpoint
    Given I GET all orders endpoints
    When I GET HTTP request with valid endpoints for get all orders
    And I receive response data for get all orders
    Then I receive valid HTTP response 200 for get all orders

  Scenario: As an admin, I can't get all order with invalid endpoint
    Given I GET all orders endpoint
    When I GET HTTP request with invalid endpoints for get all orders
    Then I receive valid HTTP response 404 for get all orders

  Scenario: As an admin, I can't get all order because method is invalid
    Given I GET all orders endpoint url
    When I GET HTTP request with invalid method for get all orders
    Then I receive valid HTTP response 405 for get all orders

  Scenario: As an admin, I can get order by ID with valid endpoint
    Given I GET orders endpoints by ID
    When I GET orders HTTP request with valid ID
    And I receive response data for get order by ID
    Then I receive valid HTTP response 200 for get order by ID

  Scenario: As an admin, I can't get order by id because id is invalid
    Given I GET orders endpoint by ID
    When I GET orders HTTP request with invalid ID
    Then I receive valid HTTP response 400 for get order by ID

  Scenario: As an admin, I can't get order by id because endpoint is invalid
    Given I GET orders endpoint url by ID
    When I GET orders HTTP request with invalid endpoint
    Then I receive valid HTTP status 401 for get order by ID