package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCreateCommentPositive {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set a POST endpoint")
    public String setCommentPostEndpoint() {
        return url + "products/85892/comments";
    }

    @Step("I send a valid POST HTTP request")
    public void sendPostCommentHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoiYWFAbWFpbC5jb20ifQ.7POMMs7flgOaoS3mcGSF-K34HIyd-7LdX54jJFTpx_M")
                .contentType("application/json")
                .body(requestBody.toJSONString())
                .post(setCommentPostEndpoint());
    }

    @Step("I should receive a valid HTTP response for comments with status code 200 OK")
    public void receiveHttpCommentResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

}
