package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetCategoryIDNegative {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set an invalid GET endpoint for retrieving a category by ID")
    public String setInvalidGetCategoryByIdEndpoint(){
        return url + "categories/1";

    }
    @Step("I send an HTTP GET request with a valid category ID")
    public void sendGetRequestWithValidCategoryIdToInvalidEndpoint(){
        SerenityRest.given()
                .when()
                .get(setInvalidGetCategoryByIdEndpoint());

    }
    @Step("I receive for category product with a valid HTTP response code 404 Not Found")
    public void validateInvalidCategoryByIdResponseCode404(){
        restAssuredThat(response ->response.statusCode(404));
        restAssuredThat(response -> response.body("$", notNullValue()));}

    @Step("I don't receive valid data for category product details by ID 1")
    public void emptyDataID() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
