Feature: Authentication

  As a Admin
  I want to authentication for an account
  So that I can manage to my account

#   [Positive] Register with valid data
  Scenario:  As an admin, I can Register with valid data
    Given I set the POST endpoint for registration
    When I send an HTTP POST request with valid email, password, and full name
    Then I receive a valid data register HTTP response code 200 OK

  # [Negative_1] Register with duplicate email
  Scenario:  As an admin, I can't Register with duplicate email
    Given I set the Register with duplicate email POST endpoint for registration
    When I send an Register with duplicate email HTTP POST request with valid email, password, and fullname
    Then I receive a valid data register HTTP response code 400 Bad Request

  # [Negative_2] Register with invalid baseURL
  Scenario: As an admin, I can't Register with invalid baseURL
    Given I set an invalid baseURL POST endpoint for registration
    When I send an invalid baseURL HTTP POST request with valid email, password, and fullname
    Then I receive a valid data register HTTP response code 404 Not Found

  # [Negative_3] Register with empty body
  Scenario: As an admin, I can't Register with empty body
    Given I set the Register with empty body POST endpoint for registration
    When I send a Register with empty body HTTP POST request with an empty body
    Then I receive a valid HTTP response code 400 Bad Request

  # [Positive] Login with valid data
  Scenario: As an admin, I can Login with valid data
    Given I set the POST endpoint for login
    When I send an HTTP POST request with valid email and password
    Then I receive a valid data login HTTP response code 200 OK

  # [Negative_1] Log in with an empty body
  Scenario: As an admin, I can't log in with an empty body
    Given I set the POST endpoint for user login with empty body
    When I send an HTTP POST request with an empty body for Login
    Then I receive a valid login HTTP response code 400 Bad Request for empty body

  # [Negative_2] Login with invalid baseURL
  Scenario: As an admin, I can't Login with invalid baseURL
    Given I set the Login with invalid baseURL POST endpoint for login
    When I send Login with invalid baseURL HTTP POST request with valid email and password
    Then I receive a valid data create new login HTTP response code 404 Not Found

  # [Negative_3] Login with unregistered user
  Scenario: As an admin, I can't Login with unregistered user
    Given I set the POST endpoint for login with unregistered user
    When I send an HTTP POST request with valid email, password, and script test for login
    Then I receive a valid data create new login HTTP response code 400 Bad Request

  # [Negative_4] Log in with a empty email
  Scenario: As an admin, I can't log in with a empty email
    Given I set the POST endpoint for user login with empty email
    When I send an HTTP POST request with a empty email and valid password
    Then I receive a valid login HTTP response code 400 Bad Request for empty email

  # [Negative_5] Log in with an empty password
  Scenario: As an admin, I can't log in with an empty password
    Given I set the POST endpoint for user login with password
    When I send an HTTP POST request with a valid email and an empty password
    Then I receive a valid login HTTP response code 400 Bad Request for empty password

  # [Positive] Get user information
  Scenario: As an admin, I can get my user information with a valid baseURL and token
    Given I set the GET endpoint for retrieving user information
    When I send an HTTP GET request with a valid token
    Then I receive a valid user information HTTP response code 200 OK

  # [Negative_1] Get user information with an invalid baseURL
  Scenario: As an admin, I can't get my user information with an invalid baseURL
    Given I set an invalid GET endpoint for retrieving user information
    When I send an HTTP GET request with a valid token with an invalid baseURL
    Then I receive a valid user information HTTP response code 404 Not Found

  # [Negative_2] Get user information with an invalid token
  Scenario: As an admin, I can't get my user information with an invalid token
    Given I set the GET endpoint for retrieving user information for invalid token
    When I send an HTTP GET request with an invalid token
    Then I receive a valid user information HTTP response code 401 Unauthorized