package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.restapi.Authentications.*;

public class AuthenticationsSteps {

    @Steps
    RegisterPositive RegisterPositive;
    @Steps
    RegisterNegative_1 RegisterNegative_1;
    @Steps
    RegisterNegative_2 RegisterNegative_2;
    @Steps
    RegisterNegative_3 RegisterNegative_3;
    @Steps
    LoginPositive LoginPositive;
    @Steps
    LoginNegative_1 LoginNegative_1;
    @Steps
    LoginNegative_2 LoginNegative_2;
    @Steps
    LoginNegative_3 LoginNegative_3;
    @Steps
    LoginNegative_4 LoginNegative_4;
    @Steps
    LoginNegative_5 LoginNegative_5;
    @Steps
    GetInfoPositive GetInfoPositive;
    @Steps
    GetInfoNegative_1 GetInfoNegative_1;
    @Steps
    GetInfoNegative_2 GetInfoNegative_2;

    //    [Positive] Register with valid data
   @Given("I set the POST endpoint for registration")
    public void getRegisterEndpoint() {
        RegisterPositive.getRegisterEndpoint();
    }
    @When("I send an HTTP POST request with valid email, password, and full name")
    public void sendPostHTTPRegister() {
        RegisterPositive.sendPostHTTPRegister();
    }
    @Then("I receive a valid data register HTTP response code 200 OK")
            public void validateRegister200() {
        RegisterPositive.validateRegister200();
    }


    //    [Negative_1] Register with duplicate email
    @Given("I set the Register with duplicate email POST endpoint for registration")
    public void setRegisterEndpointWithDuplicateEmail() {
        RegisterNegative_1.getNegative1RegisterEndpoint();
    }
    @When("I send an Register with duplicate email HTTP POST request with valid email, password, and fullname")
    public void sendDuplicatePostHTTPRegister() {
        RegisterNegative_1.sendNegative1PostHTTPRegister();
    }
    @Then("I receive a valid data register HTTP response code 400 Bad Request")
    public void validateRegister400DuplicateEmail() {
        RegisterNegative_1.validateNegative1Register();
    }

    //    [Negative_2] Register with invalid baseURL
    @Given("I set an invalid baseURL POST endpoint for registration")
    public void getNegative2RegisterEndpoint() {
        RegisterNegative_2.getNegative2RegisterEndpoint();
    }
    @When("I send an invalid baseURL HTTP POST request with valid email, password, and fullname")
    public void sendNegative2PostHTTPRegister() {
        RegisterNegative_2.sendNegative2PostHTTPRegister();
    }
    @Then("I receive a valid data register HTTP response code 404 Not Found")
    public void validateNegative2Register() {
        RegisterNegative_2.validateNegative2Register();
    }

    //    [Negative_3] Register with empty body
    @Given("I set the Register with empty body POST endpoint for registration")
    public void setNegative3RegisterEndpoint() {
        RegisterNegative_3.setNegative3RegisterEndpoint();
    }
    @When("I send a Register with empty body HTTP POST request with an empty body")
    public void sendNegative3PostHTTPRegister() {
        RegisterNegative_3.sendNegative3PostHTTPRegister();
    }
    @Then("I receive a valid HTTP response code 400 Bad Request")
    public void validateNegative3Register() {
        RegisterNegative_3.validateNegative3Register();
    }

    // [Positive] Login with valid data
    @Given("I set the POST endpoint for login")
    public void setLoginEndpoint() {
        LoginPositive.setLoginEndpoint();
    }
    @When("I send an HTTP POST request with valid email and password")
    public void sendValidLoginRequest() {
        LoginPositive.sendValidLoginRequest();
    }
    @Then("I receive a valid data login HTTP response code 200 OK")
    public void validateLogin200() {
        LoginPositive.validateLogin200();
    }

    // [Negative_1] Log in with an empty body
    @Given("I set the POST endpoint for user login with empty body")
    public void setLoginEndpointWithEmptyBody() {
        LoginNegative_1.setLoginEndpointWithEmptyBody();
    }
    @When("I send an HTTP POST request with an empty body for Login")
    public void sendLoginRequestWithEmptyBody() {
        LoginNegative_1.sendLoginRequestWithEmptyBody();
    }
    @Then("I receive a valid login HTTP response code 400 Bad Request for empty body")
    public void validateLogin400ForEmptyBody() {
        LoginNegative_1.validateLogin400ForEmptyBody();
    }

    //    [Negative_2] Login with invalid baseURL
    @Given("I set the Login with invalid baseURL POST endpoint for login")
    public void setInvalidBaseUrlForLogin() {
        LoginNegative_2.setInvalidBaseUrlForLogin();
    }
    @When("I send Login with invalid baseURL HTTP POST request with valid email and password")
    public void sendLoginRequestWithInvalidBaseUrl() {
        LoginNegative_2.sendLoginRequestWithInvalidBaseUrl();
    }
    @Then("I receive a valid data create new login HTTP response code 404 Not Found")
    public void validateLogin404() {
        LoginNegative_2.validateLogin404();
    }

    //    [Negative_3] Login with unregistered user
    @Given("I set the POST endpoint for login with unregistered user")
    public void setLoginEndpointForUnregisteredUser() {
        LoginNegative_3.setLoginEndpointForUnregisteredUser();
    }
    @When("I send an HTTP POST request with valid email, password, and script test for login")
    public void sendLoginRequestWithScriptTest() {
        LoginNegative_3.sendLoginRequestWithScriptTest();
    }
    @Then("I receive a valid data create new login HTTP response code 400 Bad Request")
    public void validateLogin400ForUnregisteredUser() {
        LoginNegative_3.validateLogin400ForUnregisteredUser();
    }

    // [Negative_4] Log in with empty email
    @Given("I set the POST endpoint for user login with empty email")
    public void setLoginEndpointWithEmptyEmail() {
        LoginNegative_4.setLoginEndpointWithEmptyEmail();
    }
    @When("I send an HTTP POST request with a empty email and valid password")
    public void sendLoginRequestWithEmptyEmail() {
        LoginNegative_4.sendLoginRequestWithEmptyEmail();
    }
    @Then("I receive a valid login HTTP response code 400 Bad Request for empty email")
    public void validateLogin400ForEmptyEmail() {
        LoginNegative_4.validateLogin400ForEmptyEmail();
    }

    // [Negative_5] Log in with an empty password
    @Given("I set the POST endpoint for user login with password")
    public void setLoginEndpointWithEmptyPassword() {
        LoginNegative_5.setLoginEndpointWithEmptyPassword();
    }
    @When("I send an HTTP POST request with a valid email and an empty password")
    public void sendLoginRequestWithEmptyPassword() {
        LoginNegative_5.sendLoginRequestWithEmptyPassword();
    }
    @Then("I receive a valid login HTTP response code 400 Bad Request for empty password")
    public void validateLogin400ForEmptyPassword() {
        LoginNegative_5.validateLogin400ForEmptyPassword();
    }

   // [Positive] Get user information
    @Given("I set the GET endpoint for retrieving user information")
    public void setGetUserInformationEndpoint() {
        GetInfoPositive.setGetUserInformationEndpoint();
    }
    @When("I send an HTTP GET request with a valid token")
    public void sendGetUserInformationRequestWithValidToken() {
        GetInfoPositive.sendGetUserInformationRequestWithValidToken();
    }
    @Then("I receive a valid user information HTTP response code 200 OK")
    public void validateGetUser200Response() {
        GetInfoPositive.validateGetUser200Response();
    }

    // [Negative_1] Get user information with an invalid baseURL
    @Given("I set an invalid GET endpoint for retrieving user information")
    public void setInvalidGetUserInformationEndpoint() {
        GetInfoNegative_1.setInvalidGetUserInformationEndpoint();
    }
    @When("I send an HTTP GET request with a valid token with an invalid baseURL")
    public void sendGetUserInformationRequestWithInvalidBaseURL() {
        GetInfoNegative_1.sendGetUserInformationRequestWithInvalidBaseURL();
    }
    @Then("I receive a valid user information HTTP response code 404 Not Found")
    public void validateGetUser404ForEmptyEmailPassword() {
        GetInfoNegative_1.validateGetUser400ForEmptyEmailPassword();
    }

    // [Negative_2] Get user information with an invalid token
    @Given("I set the GET endpoint for retrieving user information for invalid token")
    public void setGetUserInformationEndpoint2() {
        GetInfoNegative_2.setGetUserInformationEndpoint2();
    }
    @When("I send an HTTP GET request with an invalid token")
    public void sendGetUserInformationRequestWithInvalidToken() {
        GetInfoNegative_2.sendGetUserInformationRequestWithInvalidToken();
    }
    @Then("I receive a valid user information HTTP response code 401 Unauthorized")
    public void validateGetUser401ForInvalidToken() {
        GetInfoNegative_2.validateGetUser401ForInvalidToken();
    }
}
