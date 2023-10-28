package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AssignProductRatingPositive {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set POST endpoints")
    public String setRatingPostApiEndpoint() {
        return url + "products/85892/ratings";
    }

    @Step("I send a POST assign product rating HTTP request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 4);

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoiYWFAbWFpbC5jb20ifQ.7POMMs7flgOaoS3mcGSF-K34HIyd-7LdX54jJFTpx_M")
                .contentType("application/json")
                .post(setRatingPostApiEndpoint());
    }

    @Step("I should receive a valid HTTP response with status code 200 OK")
    public void receiveHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

}
