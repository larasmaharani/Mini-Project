package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.restapi.Orders.Order;

public class OrderSteps {
    @Steps
    Order orders;

    // Create a new order
    @Given("I POST create orders endpoints")
    public void postOrdersEndpoints() {
        orders.postOrdersEndpoints();
    }
    @When("I POST HTTP request for create orders with valid data")
    public void postHTTPRequestCreateNewOrder() {
        orders.postHTTPRequestCreateNewOrder();
    }
    @And("I receive response data for create orders")
    public void receiveResponseCreateNewOrder() {
        orders.receiveResponseCreateNewOrder();
    }
    @Then("I receive valid HTTP response 200 for create orders")
    public void receiveResponsceCode200CreateOrders() {
        orders.receiveResponsceCode200CreateOrders();
    }

    // Failed create new order because endpoint is invalid
    @Given("I POST create orders endpoint")
    public void postOrdersEndpoint() {
        orders.postOrdersEndpoint();
    }
    @When("I POST HTTP request for create orders with invalid endpoint")
    public void postHTTPRequestCreateNewOrderInvEnd() {
        orders.postHTTPRequestCreateNewOrderInvEnd();
    }
    @Then("I receive HTTP response 404 for create orders")
    public void receiveResponsceCode404CreateOrders() {
        orders.receiveResponsceCode404CreateOrders();
    }

    // Failed create anew order because body is empty
    @Given("I POST create orders endpoint url")
    public void postOrdersEndpointUrl() {
        orders.postOrdersEndpointUrl();
    }
    @When("I POST HTTP request for create orders with empty body")
    public void postHTTPRequestCreateNewOrderEmtBody() {
        orders.postHTTPRequestCreateNewOrderEmptBody();
    }
    @Then("I receive HTTP response 400 for create orders")
    public void receiveResponsceCode400CreateOrders() {
        orders.receiveResponsceCode400CreateOrders();
    }

    // Failed create anew order because method is invalid
    @Given("I POST create orders endpoints url")
    public void postOrdersEndpointsUrl() {
        orders.postOrdersEndpointsUrl();
    }
    @When("I POST HTTP request for create orders without token")
    public void postHTTPRequestCreateNewOrderInvParam() {
        orders.postHTTPRequestCreateNewOrderInvParam();
    }
    @Then("I receive HTTP status 401 for create orders")
    public void receiveStatusCode401CreateOrders() {
        orders.receiveStatusCode401CreateOrders();
    }

    // Get all orders
    @Given("I GET all orders endpoints")
    public void getAllOrdersEndpoints() {
        orders.getAllOrdersEndpoints();
    }
    @When("I GET HTTP request with valid endpoints for get all orders")
    public void getHTTPRequestAllOrders() {
        orders.getHTTPRequestAllOrders();
    }
    @And("I receive response data for get all orders")
    public void receiveResponseGetAllOrders() {
        orders.receiveResponseGetAllOrders();
    }
    @Then("I receive valid HTTP response 200 for get all orders")
    public void receiveResponseCode200GetAllOrders() {
        orders.receiveResponseCode200GetAllOrders();
    }

    // Failed get all order with invalid endpoint
    @Given("I GET all orders endpoint")
    public void getAllOrdersEndpoint() {
        orders.getAllOrdersEndpoint();
    }
    @When("I GET HTTP request with invalid endpoints for get all orders")
    public void getHTTPRequestAllOrdersInvEnd() {
        orders.getHTTPRequestAllOrdersInvEnd();
    }
    @Then("I receive valid HTTP response 404 for get all orders")
    public void receiveResponseCode404GetAllOrders() {
        orders.receiveResponseCode404etAllOrders();
    }

    // Failed get all order with invalid method
    @Given("I GET all orders endpoint url")
    public void getAllOrdersEndpointUrl() {
        orders.getAllOrdersEndpointUrl();
    }
    @When("I GET HTTP request with invalid method for get all orders")
    public void getHTTPRequestAllOrdersInvMeth() {
        orders.getHTTPRequestAllOrdersInvMeth();
    }
    @Then("I receive valid HTTP response 405 for get all orders")
    public void receiveResponseCode405GetAllOrders() {
        orders.receiveResponseCode405etAllOrders();
    }

    // Get order by ID
    @Given("I GET orders endpoints by ID")
    public void getOrderEndpointsByID() {
        orders.getOrderEndpointsByID();
    }
    @When("I GET orders HTTP request with valid ID")
    public void getHTTPRequestOrdersByID() {
        orders.getHTTPRequestOrdersByID();
    }
    @And("I receive response data for get order by ID")
    public void receiveResponseGetOrderByID() {
        orders.receiveResponseGetOrderByID();
    }
    @Then("I receive valid HTTP response 200 for get order by ID")
    public void receiveResponseCode200GetOrderByID() {
        orders.receiveResponseCode200GetOrderByID();
    }

    // Failed get order by id because id is invalid
    @Given("I GET orders endpoint by ID")
    public void getOrderEndpointByID() {
        orders.getOrderEndpointByID();
    }
    @When("I GET orders HTTP request with invalid ID")
    public void getHTTPRequestOrderByID() {
        orders.getHTTPRequestOrderByID();
    }
    @Then("I receive valid HTTP response 400 for get order by ID")
    public void receiveResponseCode400GetOrderByID() {
        orders.receiveResponseCode400GetOrderByID();
    }

    // Failed get order by id because endpoint is invalid
    @Given("I GET orders endpoint url by ID")
    public void getOrderEndpointUrlByID() {
        orders.getOrderEndpointUrlByID();
    }
    @When("I GET orders HTTP request with invalid endpoint")
    public void getHTTPRequestOrderByIDInvEnd() {
        orders.getHTTPRequestOrderByIDInvEnd();
    }
    @Then("I receive valid HTTP status 401 for get order by ID")
    public void receiveStatusCode400GetOrderByID() {
        orders.receiveStatusCode400GetOrderByID();
    }
}
