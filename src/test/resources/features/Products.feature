Feature: Products

  As a admin
  I want to access product details
  So that I can manage products

  # [Positive] Get all products
  Scenario: As an admin, I can get all product when using a valid baseURL
    Given I set a GET endpoints
    When I send HTTP GET request
    Then I receive a valid Get HTTP response code 200 OK
    And I receive valid data for all product details

  # [Negative] Get all products with an invalid baseURL
  Scenario: As an admin, I can't get all product when using an invalid baseURL
    Given I set the GET endpoint
    When I send a request to the HTTP GET
    Then I receive a valid HTTP response code 404 Not Found
    And I don't receive valid data for all product details

  # [Positive] Create a new product
  Scenario: As an admin, I can create a new product with valid data
    Given I set an POST endpoint
    When I send the POST HTTP request
    Then I receive a valid HTTP response code 200 OK

  # [Negative] Create a new product
  Scenario: As an admin, I can't create a new product when using an invalid baseURL
    Given I set a POST endpoint
    When I send a request to the HTTP POST
    Then I receive a HTTP response code 400 Bad Request

  # [Positive] Get product By ID
  Scenario: As an admin, I can get single product details using a valid ID
    Given I set the GET endpoints by ID 85892
    When I send HTTP GET to the request
    Then I receive valid product by ID HTTP response code 200 OK
    And I receive valid data for a single product by ID 85892

  # [Negative] Get product By ID
  Scenario: As an admin, I can't get single product details using a invalid ID
    Given I set a GET endpoint by ID 1
    When I send a HTTP GET request
    Then I receive valid HTTP response code 404 Not Found
    And I don't receive valid data for product details by ID 1

  # [Positive] Delete a product
  Scenario: As an admin, I can delete an existing product using a valid baseURL
    Given I set DELETE endpoints
    When I send a DELETE HTTP request
    Then I receive a valid DELETE HTTP response code 200 OK

  # [Negative] Delete a product with an invalid baseURL
  Scenario: As an admin, I can't delete an existing product when using an invalid baseURL
    Given I set DELETE endpoint
    When I send DELETE HTTP request to endpoints
    Then I receive a valid DELETE HTTP response code 404 Not Found

  # [Positive] Assign a product rating
  Scenario: As an admin, I can assign a product rating with a valid baseURL
    Given I set POST endpoints
    When I send a POST assign product rating HTTP request
    Then I should receive a valid HTTP response with status code 200 OK

  # [Negative] Assign a product rating with an invalid baseURL
  Scenario: As an admin, I cannot assign a product rating when using an invalid baseURL
    Given I set the POST endpoints
    When I send a POST HTTP request
    Then I should receive a valid HTTP response with status code 404 Not Found

  # [Positive] Get product ratings
  Scenario: As an admin, I can get product ratings when using a valid BaseURL
    Given I set a GET rating endpoints
    When I send an HTTP GET request
    Then I receive valid HTTP response code 200 OK
    And I receive valid data for product ratings

  # [Negative] Get product ratings
  Scenario: As an admin, I can't get product ratings when using a invalid BaseURL
    Given I set invalid GET rating endpoints
    When I send GET to HTTP request
    Then I receive a rating HTTP response code 404 Not Found
    And I don't receive valid data for product ratings

  # [Positive] Create a comment for a product
  Scenario: As an admin, I can create a comment for a product with a valid baseURL
    Given I set a POST endpoint
    When I send a valid POST HTTP request
    Then I should receive a valid HTTP response for comments with status code 200 OK

  # [Negative] Create a comment for a product
  Scenario: As an admin, I cannot create a comment for a product with an invalid baseURL
    Given I set a POST comment endpoints
    When I send the POST invalid HTTP request
    Then I should receive a valid HTTP comment response code 404 Not Found

  # [Positive] Get product comments
  Scenario: As an admin, I can get comments using a valid BaseURL
    Given I set a GET comment endpoints
    When I send an HTTP GET request for comment products
    Then I receive valid comment HTTP response code 200 OK
    And I receive valid data for comment products

  # [Negative] Get product comments
  Scenario: As an admin, I can't get comments using a invalid BaseURL
    Given I set GET invalid comment endpoints
    When I send HTTP GET request for comment products
    Then I receive valid comment HTTP response code 404 Not Found
    And I don't receive valid data for comment products