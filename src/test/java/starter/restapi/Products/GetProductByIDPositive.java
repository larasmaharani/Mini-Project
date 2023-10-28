package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductByIDPositive {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set the GET endpoints by ID 85892")
    public String setGetIDEndpoints(){
        return url + "products/85892";

    }
    @Step("I send HTTP GET to the request")
    public void getIDHTTPrequest(){
        SerenityRest.given()
                .when()
                .get(setGetIDEndpoints());

    }
    @Step("I receive valid product by ID HTTP response code 200 OK")
    public void HTTPGetResponse200(){
        restAssuredThat(response ->response.statusCode(200));
    }

    @Step("I receive valid data for a single product by ID 85892")
    public void valiDataID() {
        restAssuredThat(response -> response.body("data.ID", equalTo(85892)));
    }
}
