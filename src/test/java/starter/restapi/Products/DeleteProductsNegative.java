package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProductsNegative {
    protected String url = "https://altashop-api.fly.dev/api/";
    @Step("I set DELETE endpoint")
    public String setDeleteWrongEndpoint(){
        return url + "product/11299";
    }
    @Step("I send DELETE HTTP request to endpoints")
    public void sendHTTPDeleteRequest(){
        SerenityRest.given().delete(setDeleteWrongEndpoint());
    }
    @Step("I receive a valid DELETE HTTP response code 404 Not Found")
    public void validHttpresponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

}
