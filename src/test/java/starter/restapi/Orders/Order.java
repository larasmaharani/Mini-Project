package starter.restapi.Orders;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Order {
    protected static String url = "https://altashop-api.fly.dev/api/";

    // Create a new order
    @Step("I POST create orders endpoints")
    public String postOrdersEndpoints() {
        return url + "orders";
    }
    @Step("I POST HTTP request for create orders with valid data")
    public void postHTTPRequestCreateNewOrder() {

        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 11649);
        orderItem.put("quantity", 1);
        orderItems.add(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.add(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(postOrdersEndpoints());
    }
    @Step("I receive response data for create orders")
    public void receiveResponseCreateNewOrder() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid HTTP response 200 for create orders")
    public void receiveResponsceCode200CreateOrders() {
        restAssuredThat(response -> response.statusCode(200));
    }

    // Failed create new order because endpoint is invalid
    @Step("I POST create orders endpoint")
    public String postOrdersEndpoint() {
        return url + "pesann";
    }
    @Step("I POST HTTP request for create orders with invalid endpoint")
    public void postHTTPRequestCreateNewOrderInvEnd() {

        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 11649);
        orderItem.put("quantity", 1);
        orderItems.add(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.add(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(postOrdersEndpoint());
    }
    @Step("I receive HTTP response 404 for create orders")
    public void receiveResponsceCode404CreateOrders() {
        restAssuredThat(response -> response.statusCode(404));
    }

    // Failed create new order because body is empty
    @Step("I POST create orders endpoint url")
    public String postOrdersEndpointUrl() {
        return url + "orders";
    }
    @Step("I POST HTTP request for create orders with empty body")
    public void postHTTPRequestCreateNewOrderEmptBody() {


        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .contentType("application/json")
                .post(postOrdersEndpointUrl());
    }
    @Step("I receive HTTP response 400 for create orders")
    public void receiveResponsceCode400CreateOrders() {
        restAssuredThat(response -> response.statusCode(400));
    }

    // Failed create a new order without token
    @Step("I POST create orders endpoints url")
    public String postOrdersEndpointsUrl() {
        return url + "orders";
    }
    @Step("I POST HTTP request for create orders without token")
    public void postHTTPRequestCreateNewOrderInvParam() {

        JSONArray orderItems = new JSONArray();
        JSONObject orderItem = new JSONObject();
        orderItem.put("product_id", 11649);
        orderItem.put("quantity", 1);
        orderItems.add(orderItem);

        JSONArray requestBody = new JSONArray();
        JSONObject orderCreate = new JSONObject();
        orderCreate.put("order_items", orderItems);
        requestBody.add(orderCreate);

        SerenityRest
                .given()
                .header("Authorization", "Bearer")
                .contentType("application/json")
                .body(requestBody.toString())
                .post(postOrdersEndpointsUrl());
    }
    @Step("I receive HTTP status 401 for create orders")
    public void receiveStatusCode401CreateOrders() {
        restAssuredThat(response -> response.statusCode(401));
    }

    //Scenario: TC02 - Get all orders
    @Step("I GET all orders endpoints")
    public String getAllOrdersEndpoints() {
        return url + "orders";
    }
    @Step("I GET HTTP request with valid endpoints for get all orders")
    public void getHTTPRequestAllOrders() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .get(getAllOrdersEndpoints());
    }
    @Step("I receive response data for get all orders")
    public void receiveResponseGetAllOrders() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid HTTP response 200 for get all orders")
    public void receiveResponseCode200GetAllOrders() {
        restAssuredThat(response -> response.statusCode(200));
    }

    // Failed get all order with invalid endpoint
    @Step("I GET all orders endpoint")
    public String getAllOrdersEndpoint() {
        return url + "order";
    }
    @Step("I GET HTTP request with invalid endpoints for get all orders")
    public void getHTTPRequestAllOrdersInvEnd() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .get(getAllOrdersEndpoint());
    }
    @Step("I receive valid HTTP response 404 for get all orders")
    public void receiveResponseCode404etAllOrders() {
        restAssuredThat(response -> response.statusCode(404));
    }

    // Failed get all order with invalid method
    @Step("I GET all orders endpoint url")
    public String getAllOrdersEndpointUrl() {
        return url + "orders";
    }
    @Step("I GET HTTP request with invalid method for get all orders")
    public void getHTTPRequestAllOrdersInvMeth() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .put(getAllOrdersEndpointUrl());
    }
    @Step("I receive valid HTTP response 405 for get all orders")
    public void receiveResponseCode405etAllOrders() {
        restAssuredThat(response -> response.statusCode(405));
    }

    // Get order by ID
    @Step("I GET orders endpoints by ID")
    public String getOrderEndpointsByID() {
        return url + "orders/12467";
    }
    @Step("I GET orders HTTP request with valid ID")
    public void getHTTPRequestOrdersByID() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .get(getOrderEndpointsByID());
    }
    @Step("I receive response data for get order by ID")
    public void receiveResponseGetOrderByID() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive valid HTTP response 200 for get order by ID")
    public void receiveResponseCode200GetOrderByID() {
        restAssuredThat(response -> response.statusCode(200));
    }

    // Failed get order by id because id is invalid
    @Step("I GET orders endpoint by ID")
    public String getOrderEndpointByID() {
        return url + "orders/12467abc";
    }
    @Step("I GET orders HTTP request with invalid ID")
    public void getHTTPRequestOrderByID() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .get(getOrderEndpointByID());
    }
    @Step("I receive valid HTTP response 400 for get order by ID")
    public void receiveResponseCode400GetOrderByID() {
        restAssuredThat(response -> response.statusCode(400));
    }

    // Failed get order by id because endpoint is invalid
    @Step("I GET orders endpoint by ID")
    public String getOrderEndpointUrlByID() {
        return url + "order/12467";
    }
    @Step("I GET orders HTTP request with invalid ID")
    public void getHTTPRequestOrderByIDInvEnd() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer")
                .contentType("application/json")
                .post(postOrdersEndpointsUrl());
    }
    @Step("I receive valid HTTP status 401 for get order by ID")
    public void receiveStatusCode400GetOrderByID() {
        restAssuredThat(response -> response.statusCode(401));
    }
}
