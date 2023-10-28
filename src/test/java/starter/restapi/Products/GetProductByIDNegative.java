package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetProductByIDNegative {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set a GET endpoint by ID 1")
    public String setIDEndpoints(){
        return url + "products/112";

    }
    @Step("I send a HTTP GET request")
    public void HTTPGETRequest(){
        SerenityRest.given()
                .when()
                .get(setIDEndpoints());

    }
    @Step("I receive valid HTTP response code 404 Not Found")
    public void HTTPGetResponse404(){
        restAssuredThat(response ->response.statusCode(404));
        restAssuredThat(response -> response.body("$", notNullValue()));}

    @Step("I don't receive valid data for product details by ID 1")
    public void emptyDataID() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
