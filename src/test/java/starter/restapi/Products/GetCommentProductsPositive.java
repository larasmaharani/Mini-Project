package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetCommentProductsPositive {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set a GET comment endpoints")
    public String setValidCommentEndpoints(){
        return url + "products/2/comments";

    }
    @Step("I send an HTTP GET request for comment products")
    public void commentGetHTTPRequest(){
        SerenityRest.given()
                .when()
                .get(setValidCommentEndpoints());

    }
    @Step("I receive valid comment HTTP response code 200 OK")
    public void HTTPCommentResponse200(){
        restAssuredThat(response ->response.statusCode(200));
        restAssuredThat(response -> response.body("$", notNullValue()));

    }
    @Step("I receive valid data for comment products")
    public void validCommentData() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
