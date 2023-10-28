package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.restapi.Products.*;

public class ProductSteps {

    @Steps
    GetAllProductsPositive getAllProductsPositive;
    @Steps
    GetAllProductsNegative getAllProductsNegative;
    @Steps
    PostCreateNewProductPositive PostCreateNewProductPositive;
    @Steps
    PostCreateNewProductNegative PostCreateNewProductNegative;
    @Steps
    GetProductByIDPositive getProductByIDPositive;
    @Steps
    GetProductByIDNegative getProductByIDNegative;
    @Steps
    DeleteProductsPositive deleteProductsPositive;
    @Steps
    DeleteProductsNegative deleteProductsNegative;
    @Steps
    AssignProductRatingPositive AssignProductRatingPositive;
    @Steps
    AssignProductRatingNegative AssignProductRatingNegative;
    @Steps
    GetRatingProductsPositive getRatingProductsPositive;
    @Steps
    GetRatingProductsNegative getRatingProductsNegative;
    @Steps
    PostCreateCommentPositive PostCreateCommentPositive;
    @Steps
    PostCreateCommentNegative PostCreateCommentNegative;
    @Steps
    GetCommentProductsPositive getCommentProductsPositive;
    @Steps
    GetCommentProductsNegative getCommentProductsNegative;

    //  [Positive] Get all products
    @Given("I set a GET endpoints")
    public void setGetEndpoints() {
        getAllProductsPositive.setGetEndpoints();
    }
    @When("I send HTTP GET request")
    public void getHTTPrequest() {
        getAllProductsPositive.getHTTPrequest();
    }
    @Then("I receive a valid Get HTTP response code 200 OK")
    public void HTTPresponse200() {
        getAllProductsPositive.HTTPresponse200();
    }
    @And("I receive valid data for all product details")
    public void valiData() {
        getAllProductsPositive.valiData();
    }

    // [Negative] Get all products
    @Given("I set the GET endpoint")
    public void GetEndpoints() {
        getAllProductsNegative.GetEndpoints();
    }
    @When("I send a request to the HTTP GET")
    public void partGetHTTPRequest() {
        getAllProductsNegative.partGetHTTPRequest();
    }
    @Then("I receive a valid HTTP response code 404 Not Found")
    public void HTTPresponse404() {
        getAllProductsNegative.HTTPresponse404();
    }
    @And("I don't receive valid data for all product details")
    public void emptyData() {
        getAllProductsNegative.emptyData();
    }

    //    [Positive] Create a new product
    @Given("I set an POST endpoint")
    public void givenISetPOSTEndpoint() {
        PostCreateNewProductPositive.setPostApiEndpoint();
    }
    @When("I send the POST HTTP request")
    public void whenISendPOSTHTTPRequest() {
        PostCreateNewProductPositive.sendPostHttpRequest();
    }
    @Then("I receive a valid HTTP response code 200 OK")
    public void thenIReceiveValidHTTPResponseCode200OK() {
        PostCreateNewProductPositive.receiveHttpResponseCode200();
    }

    // [Negative] Create a new product
    @Given("I set the POST endpoint")
    public void setNegativePostApiEndpoint() {
        PostCreateNewProductNegative.setNegativePostApiEndpoint();
    }
    @When("I send a request to the HTTP POST")
    public void sendNegativePostHttpRequest() {
        PostCreateNewProductNegative.sendNegativePostHttpRequest();
    }
    @Then("I receive a HTTP response code 400 Bad Request")
    public void receiveHttpResponseCode400() {
        PostCreateNewProductNegative.receiveHttpResponseCode400();
    }

    //    [Positive] Get product By ID
    @Given("I set the GET endpoints by ID 85892")
    public void setGetIDEndpoints() {
        getProductByIDPositive.setGetIDEndpoints();
    }
    @When("I send HTTP GET to the request")
    public void getIDHTTPrequest() {
        getProductByIDPositive.getIDHTTPrequest();
    }
    @Then("I receive valid product by ID HTTP response code 200 OK")
    public void HTTPGetResponse200() {
        getProductByIDPositive.HTTPGetResponse200();
    }
    @And("I receive valid data for a single product by ID 85892")
    public void valiDataID() {
        getProductByIDPositive.valiDataID();
    }

    //    [Negative] Get product By ID
    @Given("I set a GET endpoint by ID 1")
    public void setIDEndpoints() {
        getProductByIDNegative.setIDEndpoints();
    }
    @When("I send a HTTP GET request")
    public void HTTPGETRequest() {
        getProductByIDNegative.HTTPGETRequest();
    }
    @Then("I receive valid HTTP response code 404 Not Found")
    public void HTTPGetResponse404() {
        getProductByIDNegative.HTTPGetResponse404();
    }
    @And("I don't receive valid data for product details by ID 1")
    public void emptyDataID() {
        getProductByIDNegative.emptyDataID();
    }

    //    [Positive] Delete a product
    @Given("I set DELETE endpoints")
    public void setDeleteEndpoint() {
        deleteProductsPositive.setDeleteEndpoint();
    }
    @When("I send a DELETE HTTP request")
    public void sendDeleteHttpRequest() {
        deleteProductsPositive.sendDeleteHttpRequest();
    }
    @Then("I receive a valid DELETE HTTP response code 200 OK")
    public void validHttpresponseCode200() {
        deleteProductsPositive.validHttpresponseCode200();
    }

    //    [Negative] Delete a product
    @Given("I set DELETE endpoint")
    public void setDeleteWrongEndpoint() {
        deleteProductsNegative.setDeleteWrongEndpoint();
    }
    @When("I send DELETE HTTP request to endpoints")
    public void sendHTTPDeleteRequest() {
        deleteProductsNegative.sendHTTPDeleteRequest();
    }
    @Then("I receive a valid DELETE HTTP response code 404 Not Found")
    public void validHttpresponseCode404() {
        deleteProductsNegative.validHttpresponseCode404();
    }

    //    [Positive] Assign a product rating
    @Given("I set POST endpoints")
    public void setRatingPostApiEndpoint() {
        AssignProductRatingPositive.setRatingPostApiEndpoint();
    }
    @When("I send a POST assign product rating HTTP request")
    public void sendPostHttpRequest() {
        AssignProductRatingPositive.sendPostHttpRequest();
    }
    @Then("I should receive a valid HTTP response with status code 200 OK")
    public void receiveHttpResponseCode200() {
        AssignProductRatingPositive.receiveHttpResponseCode200();
    }

    //    [Negative] Assign a product rating
    @Given("I set the POST endpoints")
    public void setNegativeRatingPostApiEndpoint() {
        AssignProductRatingNegative.setNegativeRatingPostApiEndpoint();
    }
    @When("I send a POST HTTP request")
    public void sendNegativeRatingPostHttpRequest() {
        AssignProductRatingNegative.sendNegativeRatingPostHttpRequest();
    }
    @Then("I should receive a valid HTTP response with status code 404 Not Found")
    public void receiveHttpResponseRatingCode404() {
        AssignProductRatingNegative.receiveHttpResponseRatingCode404();
    }

    //    [Positive] Get product ratings
    @Given("I set a GET rating endpoints")
    public void setGetRatingEndpoints() {
        getRatingProductsPositive.setGetRatingEndpoints();
    }
    @When("I send an HTTP GET request")
    public void HTTPGetRequest() {
        getRatingProductsPositive.HTTPGetRequest();
    }
    @Then("I receive valid HTTP response code 200 OK")
    public void HTTPResponse200() {
        getRatingProductsPositive.HTTPResponse200();
    }
    @And("I receive valid data for product ratings")
    public void valiDataRating() {
        getRatingProductsPositive.valiDataRating();
    }

    //    [Negative] Get product ratings
    @Given("I set invalid GET rating endpoints")
    public void GetInvalidRatingEndpoints() {
        getRatingProductsNegative.GetInvalidRatingEndpoints();
    }
    @When("I send GET to HTTP request")
    public void ratingGetHTTPRequest() {
        getRatingProductsNegative.ratingGetHTTPRequest();
    }
    @Then("I receive a rating HTTP response code 404 Not Found")
    public void HTTPRatingResponse404() {
        getRatingProductsNegative.HTTPRatingResponse404();
    }
    @And("I don't receive valid data for product ratings")
    public void emptyRatingData() {
        getRatingProductsNegative.emptyRatingData();
    }

    // [Positive] Create a comment for a product
    @Given("I set a POST endpoint")
    public void setCommentPostEndpoint() {
        PostCreateCommentPositive.setCommentPostEndpoint();
    }
    @When("I send a valid POST HTTP request")
    public void sendPostCommentHttpRequest() {
        PostCreateCommentPositive.sendPostCommentHttpRequest();
    }
    @Then("I should receive a valid HTTP response for comments with status code 200 OK")
    public void receiveHttpCommentResponseCode200() {
        PostCreateCommentPositive.receiveHttpCommentResponseCode200();
    }

    // [Negative] Create a comment for a product
    @Given("I set a POST comment endpoints")
    public void setPostCommentEndpoints() {
        PostCreateCommentNegative.setCommentNegativePostEndpoint();
    }
    @When("I send the POST invalid HTTP request")
    public void sendInvalidPostRequest() {
        PostCreateCommentNegative.sendPostCommentNegativeHttpRequest();
    }
    @Then("I should receive a valid HTTP comment response code 404 Not Found")
    public void validateHttpCommentResponse404() {
        PostCreateCommentNegative.receiveHttpCommentNegativeResponseCode404();
    }

    //    [Positive] Get product comments
    @Given("I set a GET comment endpoints")
    public void setValidCommentEndpoints() {
        getCommentProductsPositive.setValidCommentEndpoints();
    }
    @When("I send an HTTP GET request for comment products")
    public void commentGetHTTPRequest() {
        getCommentProductsPositive.commentGetHTTPRequest();
    }
    @Then("I receive valid comment HTTP response code 200 OK")
    public void HTTPCommentResponse200() {
        getCommentProductsPositive.HTTPCommentResponse200();
    }
    @And("I receive valid data for comment products")
    public void validCommentData() {
        getCommentProductsPositive.validCommentData();
    }

    //    [Negative] Get product comments
    @Given("I set GET invalid comment endpoints")
    public void GetInvalidCommentEndpoints() {
        getCommentProductsNegative.GetInvalidCommentEndpoints();
    }
    @When("I send HTTP GET request for comment products")
    public void commentHTTPGetRequest() {
        getCommentProductsNegative.commentHTTPGetRequest();
    }
    @Then("I receive valid comment HTTP response code 404 Not Found")
    public void HTTPCommentResponse404() {
        getCommentProductsNegative.HTTPCommentResponse404();
    }
    @And("I don't receive valid data for comment products")
    public void emptyCommentData() {
        getCommentProductsNegative.emptyCommentData();
    }

}