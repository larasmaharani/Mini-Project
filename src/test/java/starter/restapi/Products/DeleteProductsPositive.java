package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProductsPositive {
    protected String url = "https://altashop-api.fly.dev/api/";
    @Step("I set DELETE endpoints")
    public String setDeleteEndpoint(){
        return url + "products/11299";
    }
    @Step("I send a DELETE HTTP request")
    public void sendDeleteHttpRequest(){
        SerenityRest.given().delete(setDeleteEndpoint());
    }
    @Step("I receive a valid DELETE HTTP response code 200 OK")
    public void validHttpresponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

}
