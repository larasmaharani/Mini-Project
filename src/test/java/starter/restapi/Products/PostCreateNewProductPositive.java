package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCreateNewProductPositive {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set an POST endpoint")
    public String setPostApiEndpoint() {
        return url + "products";
    }

    @Step("I send the POST HTTP request")
    public void sendPostHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Sony PS5");
        requestBody.put("description", "play has no limits");
        requestBody.put("price", 299);
        JSONArray categories = new JSONArray();
        categories.add(1);
        requestBody.put("categories", categories);

        SerenityRest
                .given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(setPostApiEndpoint());
    }

    @Step("I receive a valid HTTP response code 200 OK")
    public void receiveHttpResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

}
