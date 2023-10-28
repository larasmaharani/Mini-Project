package starter.restapi.Categories;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllCategoriesNegative {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set an invalid GET endpoint for retrieving all categories")
    public String setInvalidGetAllCategoriesEndpoint(){
        return url + "categorie";

    }
    @Step("I send an invalid HTTP GET request for all categories")
    public void sendInvalidGetRequestForAllCategories(){
        RestAssured.defaultParser = Parser.JSON;
        SerenityRest.given()
                .accept("text/plain")
                .when()
                .get(setInvalidGetAllCategoriesEndpoint());

    }
    @Step("I receive a valid HTTP for categories product response code 404 Not Found")
    public void validateInvalidAllCategoriesResponseCode404(){
        restAssuredThat(response ->response.statusCode(404));
        restAssuredThat(response -> response.body("$", notNullValue()));
    }

    @Step("I don't receive valid data for all categories product details")
    public void emptyData() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
