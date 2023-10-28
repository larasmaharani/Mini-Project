package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.restapi.Hello.*;

public class HelloSteps {

    @Steps
    HelloPositive HelloPositive;
    @Steps
    HelloNegative_1 HelloNegative_1;
    @Steps
    HelloNegative_2 HelloNegative_2;


    // [Positive] see Hello Endpoint with Correct Data
    @Given("I set GET Hello Endpoint")
    public void setHelloApiEndpoint(){
        HelloPositive.setHelloApiEndpoint();
    }
    @When("I send GET Hello HTTP request")
    public void sendGetHelloHttpRequest(){
        HelloPositive.sendGetHelloHttpRequest();
    }
    @Then("I receive valid HTTP response code 200")
    public void validateHelloHttpResponseCode200(){
        HelloPositive.validateHelloHttpResponseCode200();
    }

    // [Negative] see Response Hello Endpoint with invalid URL
    @Given("I set GET Hello Wrong Endpoint")
    public void setHelloApiEndpoint2(){
        HelloNegative_1.setHelloApiEndpoint2();
    }
    @When("I send GET Hello HTTP request invalid URL")
    public void setWrongHelloHttpGet(){
        HelloNegative_1.setWrongHelloHttpGet();
    }
    @Then("I receive valid HTTP response code 404")
    public void validateHelloHttpResponseCode404(){
        HelloNegative_1.validateHelloHttpResponseCode404();
    }

    // [Negative] Invalid Create new user
    @Given("I set POST Hello Endpoint")
    public void setWrongHelloEndpoint(){
        HelloNegative_2.setWrongHelloEndpoint();
    }
    @When("I send POST Hello Endpoint Request")
    public void sendPostHttpRequest2(){
        HelloNegative_2.sendPostHttpRequest2();
    }
    @Then("I receive valid HTTP response code 405")
    public void receivePostHelloHttpResponseCode405(){
        HelloNegative_2.receivePostHelloHttpResponseCode405();
    }
}
