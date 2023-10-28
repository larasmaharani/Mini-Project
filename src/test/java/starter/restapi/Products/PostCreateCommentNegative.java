package starter.restapi.Products;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class PostCreateCommentNegative {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set a POST comment endpoints")
    public String setCommentNegativePostEndpoint() {
        return url + "products/2/comment";
    }

    @Step("I send the POST invalid HTTP request")
    public void sendPostCommentNegativeHttpRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", " ");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoiYWFAbWFpbC5jb20ifQ.7POMMs7flgOaoS3mcGSF-K34HIyd-7LdX54jJFTpx_M")
                .contentType("application/json")
                .body(requestBody.toJSONString())
                .post(setCommentNegativePostEndpoint());
    }

    @Step("I should receive a valid HTTP comment response code 404 Not Found")
    public void receiveHttpCommentNegativeResponseCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }


}
