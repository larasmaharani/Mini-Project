Feature: Product Categories

  As an admin
  I want to manage product categories
  So that I can create, retrieve, and delete categories

  # [Positive] Create a new category
  Scenario: As an admin, I can create a new category with valid data
    Given I set the POST endpoint for creating a category
    When I send an HTTP POST request with a valid name and description
    Then I receive a valid category creation HTTP response code 200 OK

  # [Negative] Create a new category with empty body
  Scenario: As an admin, I can't create a new category with an invalid baseURL and empty body
    Given I set an invalid Create a new category POST endpoint for creating a category
    When I send an invalid HTTP POST request with empty
    Then I receive a valid HTTP for product category with response code 404 Not Found

  # [Negative] Create a new category with an empty body
  Scenario: As an admin, I can't create a new category with an empty body
    Given I set the POST endpoint to Create a new category for creating a category
    When I send an HTTP POST request with an empty body
    Then I receive a valid HTTP for product category with response code 400 Bad Request

  # [Negative] Create a new category with an invalid baseURL and valid data
  Scenario: As an admin, I can't create a new category with an invalid baseURL and valid data
    Given I set an invalid POST endpoint for creating a category
    When I send an category HTTP POST request with a valid name and description
    Then I receive for product category with a valid HTTP response code 404 Not Found

  # [Positive] Get a category by ID
  Scenario: As an admin, I can get a category by ID with a valid baseURL
    Given I set the GET endpoint for retrieving a category by ID
    When I send an HTTP GET to category request with a valid category ID
    Then I receive a valid Get category by ID HTTP response code 200 OK
    And I receive valid data for a single product by ID 29969

  # [Negative] Get a category by ID
  Scenario: As an admin, I can't get a category by ID with an invalid baseURL
    Given I set an invalid GET endpoint for retrieving a category by ID
    When I send an HTTP GET request with a valid category ID
    Then I receive for category product with a valid HTTP response code 404 Not Found
    And I don't receive valid data for category product details by ID 1

  # [Positive] Get all categories
  Scenario: As an admin, I can get all categories with a valid baseURL
    Given I set the GET endpoint for retrieving all categories
    When I send an HTTP GET request for all categories
    Then I receive a valid Get all categories HTTP response code 200 OK
    And I receive valid data for all categories product details

  # [Negative] Get all categories
  Scenario: As an admin, I can't get all categories with an invalid baseURL
    Given I set an invalid GET endpoint for retrieving all categories
    When I send an invalid HTTP GET request for all categories
    Then I receive a valid HTTP for categories product response code 404 Not Found
    And I don't receive valid data for all categories product details

  # [Positive] Delete a category
  Scenario: As an admin, I can delete a category with a valid baseURL
    Given I set the DELETE endpoint for deleting a category
    When I send an HTTP DELETE request with a valid category ID
    Then I receive a valid delete category HTTP response code 200 OK

  # [Negative] Delete a category
  Scenario: As an admin, I can't delete a category with an invalid baseURL
    Given I set an invalid DELETE endpoint for deleting a category
    When I send an invalid HTTP DELETE request with a valid category ID
    Then I receive a valid category delete HTTP response code 404 Not Found