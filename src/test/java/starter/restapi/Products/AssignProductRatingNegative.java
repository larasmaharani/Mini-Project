package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AssignProductRatingNegative {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoints")
    public String setNegativeRatingPostApiEndpoint() {
        return url + "products/85892/rating";
    }

    @Step("I send a POST HTTP request")
    public void sendNegativeRatingPostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", " ");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoiYWFAbWFpbC5jb20ifQ.7POMMs7flgOaoS3mcGSF-K34HIyd-7LdX54jJFTpx_M")
                .contentType("application/json")
                .post(setNegativeRatingPostApiEndpoint());
    }

    @Step("I should receive a valid HTTP response with status code 404 Not Found")
    public void receiveHttpResponseRatingCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }

}
