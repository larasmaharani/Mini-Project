package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllCategoriesPositive {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set the GET endpoint for retrieving all categories")
    public String setGetAllCategoriesEndpoint(){
        return url + "categories";

    }
    @Step("I send an HTTP GET request for all categories")
    public void sendGetRequestForAllCategories(){
        SerenityRest.given()
                .when()
                .get(setGetAllCategoriesEndpoint());

    }
    @Step("I receive a valid Get all categories HTTP response code 200 OK")
    public void validateGetAllCategoriesResponseCode200(){
        restAssuredThat(response ->response.statusCode(200));
        restAssuredThat(response -> response.body("$", notNullValue()));

    }

    @Step("I receive valid data for all categories product details")
    public void validData() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
