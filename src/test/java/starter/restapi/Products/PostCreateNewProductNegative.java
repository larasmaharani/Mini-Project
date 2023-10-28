package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCreateNewProductNegative {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set a POST endpoint")
    public String setNegativePostApiEndpoint() {
        return url + "products";
    }

    @Step("I send a request to the HTTP POST")
    public void sendNegativePostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", " ");
        requestBody.put("description", " ");
        requestBody.put("price", " ");
        JSONArray categories = new JSONArray();
        categories.add(1);
        requestBody.put("categories", "  ");


        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(setNegativePostApiEndpoint());
    }

    @Step("I receive a HTTP response code 400 Bad Request")
    public void receiveHttpResponseCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
