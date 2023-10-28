package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.restapi.Categories.*;

public class CategoriesSteps {

    @Steps
    CreateNewCategoryPositive CreateNewCategoryPositive;
    @Steps
    CreateNewCategoryNegative_1 CreateNewCategoryNegative_1;
    @Steps
    CreateNewCategoryNegative_2 CreateNewCategoryNegative_2;
    @Steps
    CreateNewCategoryNegative_3 CreateNewCategoryNegative_3;
    @Steps
    GetCategoryIDPositive GetCategoryIDPositive;
    @Steps
    GetCategoryIDNegative GetCategoryIDNegative;
    @Steps
    GetAllCategoriesPositive GetAllCategoriesPositive;
    @Steps
    GetAllCategoriesNegative GetAllCategoriesNegative;
    @Steps
    DeleteCategoryPositive DeleteCategoryPositive;
    @Steps
    DeleteCategoryNegative DeleteCategoryNegative;

    // [Positive] Create a new category
    @Given("I set the POST endpoint for creating a category")
    public void setCategoryApiEndpoint() {
        CreateNewCategoryPositive.setCategoryApiEndpoint();
    }
    @When("I send an HTTP POST request with a valid name and description")
    public void sendPostRequestWithValidData() {
        CreateNewCategoryPositive.sendPostRequestWithValidData();
    }
    @Then("I receive a valid category creation HTTP response code 200 OK")
    public void validateCategoryCreationResponseCode200() {
        CreateNewCategoryPositive.validateCategoryCreationResponseCode200();
    }

    // [Negative] Create a new category with invalid data
    @Given("I set an invalid Create a new category POST endpoint for creating a category")
    public void setInvalidCategoryApiEndpoint() {
        CreateNewCategoryNegative_1.setInvalidCategoryApiEndpoint();
    }
    @When("I send an invalid HTTP POST request with empty")
    public void sendPostRequestWithValidDataToInvalidEndpoint() {
        CreateNewCategoryNegative_1.sendPostRequestWithValidDataToInvalidEndpoint();
    }
    @Then("I receive a valid HTTP for product category with response code 404 Not Found")
    public void validateInvalidCategoryResponseCode404() {
        CreateNewCategoryNegative_1.validateInvalidCategoryResponseCode404();
    }

    // [Negative] Create a new category with an empty body
    @Given("I set the POST endpoint to Create a new category for creating a category")
    public void setCategoryApiEndpoint2() {
        CreateNewCategoryNegative_2.setCategoryApiEndpoint2();
    }
    @When("I send an HTTP POST request with an empty body")
    public void sendPostRequestWithEmptyBody() {
        CreateNewCategoryNegative_2.sendPostRequestWithEmptyBody();
    }
    @Then("I receive a valid HTTP for product category with response code 400 Bad Request")
    public void validateCategoryResponseCode400() {
        CreateNewCategoryNegative_2.validateCategoryResponseCode400();
    }

    // [Negative] Create a new category with an invalid baseURL and valid data
    @Given("I set an invalid POST endpoint for creating a category")
    public void setInvalidCategoryApiEndpoint2() {
        CreateNewCategoryNegative_3.setInvalidCategoryApiEndpoint2();
    }
    @When("I send an category HTTP POST request with a valid name and description")
    public void sendPostRequestWithValidDataToInvalidEndpoint2() {
        CreateNewCategoryNegative_3.sendPostRequestWithValidDataToInvalidEndpoint2();
    }
    @Then("I receive for product category with a valid HTTP response code 404 Not Found")
    public void validateInvalidCategoryResponseCode404_2() {
        CreateNewCategoryNegative_3.validateInvalidCategoryResponseCode404_2();
    }

    // [Positive] Get a category by ID
    @Given("I set the GET endpoint for retrieving a category by ID")
    public void setGetCategoryByIdEndpoint() {
        GetCategoryIDPositive.setGetCategoryByIdEndpoint();
    }
    @When("I send an HTTP GET to category request with a valid category ID")
    public void sendGetRequestWithValidCategoryId() {
        GetCategoryIDPositive.sendGetRequestWithValidCategoryId();
    }
    @Then("I receive a valid Get category by ID HTTP response code 200 OK")
    public void validateGetCategoryByIdResponseCode200() {
        GetCategoryIDPositive.validateGetCategoryByIdResponseCode200();
    }
    @And("I receive valid data for a single product by ID 29969")
    public void validDataID(){
        GetCategoryIDPositive.validDataIDCategory();
    }

    // [Negative] Get a category by ID
    @Given("I set an invalid GET endpoint for retrieving a category by ID")
    public void setInvalidGetCategoryByIdEndpoint() {
        GetCategoryIDNegative.setInvalidGetCategoryByIdEndpoint();
    }
    @When("I send an HTTP GET request with a valid category ID")
    public void sendGetRequestWithValidCategoryIdToInvalidEndpoint() {
        GetCategoryIDNegative.sendGetRequestWithValidCategoryIdToInvalidEndpoint();
    }
    @Then("I receive for category product with a valid HTTP response code 404 Not Found")
    public void validateInvalidCategoryByIdResponseCode404() {
        GetCategoryIDNegative.validateInvalidCategoryByIdResponseCode404();
    }
    @And("I don't receive valid data for category product details by ID 1")
    public void emptyDataID(){
        GetCategoryIDNegative.emptyDataID();
    }

    // [Positive] Get all categories
    @Given("I set the GET endpoint for retrieving all categories")
    public void setGetAllCategoriesEndpoint() {
        GetAllCategoriesPositive.setGetAllCategoriesEndpoint();
    }
    @When("I send an HTTP GET request for all categories")
    public void sendGetRequestForAllCategories() {
        GetAllCategoriesPositive.sendGetRequestForAllCategories();
    }
    @Then("I receive a valid Get all categories HTTP response code 200 OK")
    public void validateGetAllCategoriesResponseCode200() {
        GetAllCategoriesPositive.validateGetAllCategoriesResponseCode200();
    }
    @And("I receive valid data for all categories product details")
    public void validData() {
        GetAllCategoriesPositive.validData();
    }

    // [Negative] Get all categories
    @Given("I set an invalid GET endpoint for retrieving all categories")
    public void setInvalidGetAllCategoriesEndpoint() {
        GetAllCategoriesNegative.setInvalidGetAllCategoriesEndpoint();
    }

    @When("I send an invalid HTTP GET request for all categories")
    public void sendInvalidGetRequestForAllCategories() {
        GetAllCategoriesNegative.sendInvalidGetRequestForAllCategories();
    }
    @Then("I receive a valid HTTP for categories product response code 404 Not Found")
    public void validateInvalidAllCategoriesResponseCode404() {
        GetAllCategoriesNegative.validateInvalidAllCategoriesResponseCode404();
    }
    @And("I don't receive valid data for all categories product details")
    public void emptyData() {
        GetAllCategoriesNegative.emptyData();
    }

    // [Positive] Delete a category
    @Given("I set the DELETE endpoint for deleting a category")
    public void setDeleteCategoryEndpoint() {
        DeleteCategoryPositive.setDeleteCategoryEndpoint();
    }

    @When("I send an HTTP DELETE request with a valid category ID")
    public void sendDeleteRequestWithValidCategoryId() {
        DeleteCategoryPositive.sendDeleteRequestWithValidCategoryId();
    }
    @Then("I receive a valid delete category HTTP response code 200 OK")
    public void validateDeleteCategoryResponseCode200() {
        DeleteCategoryPositive.validateDeleteCategoryResponseCode200();
    }

    //    [Negative] Delete a category
    @Given("I set an invalid DELETE endpoint for deleting a category")
    public void setInvalidDeleteCategoryEndpoint() {
        DeleteCategoryNegative.setInvalidDeleteCategoryEndpoint();
    }

    @When("I send an invalid HTTP DELETE request with a valid category ID")
    public void sendInvalidDeleteRequestWithValidCategoryId() {
        DeleteCategoryNegative.sendInvalidDeleteRequestWithValidCategoryId();
    }

    @Then("I receive a valid category delete HTTP response code 404 Not Found")
    public void validateInvalidDeleteCategoryResponseCode404() {
        DeleteCategoryNegative.validateInvalidDeleteCategoryResponseCode404();
    }

}