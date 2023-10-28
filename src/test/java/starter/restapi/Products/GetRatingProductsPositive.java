package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetRatingProductsPositive {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set a GET rating endpoints")
    public String setGetRatingEndpoints(){
        return url + "products/2/ratings";

    }
    @Step("I send an HTTP GET request")
    public void HTTPGetRequest(){
        SerenityRest.given()
                .when()
                .get(setGetRatingEndpoints());

    }
    @Step("I receive valid HTTP response code 200 OK")
    public void HTTPResponse200(){
        restAssuredThat(response ->response.statusCode(200));
        restAssuredThat(response -> response.body("$", notNullValue()));
    }

    @Step("I receive valid data for product ratings")
    public void valiDataRating() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
