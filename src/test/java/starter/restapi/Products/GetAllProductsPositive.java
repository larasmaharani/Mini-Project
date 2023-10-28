package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllProductsPositive {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set a GET endpoints")
    public String setGetEndpoints(){
        return url + "products";

    }
    @Step("I send HTTP GET request")
    public void getHTTPrequest(){
        SerenityRest.given()
                .when()
                .get(setGetEndpoints());

    }
    @Step("I receive a valid Get HTTP response code 200 OK")
    public void HTTPresponse200(){
        restAssuredThat(response ->response.statusCode(200));
        restAssuredThat(response -> response.body("$", notNullValue()));

    }

    @Step("I receive valid data for all product details")
    public void valiData() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
