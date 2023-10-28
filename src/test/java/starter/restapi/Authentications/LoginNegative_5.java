package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginNegative_5 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoint for user login with password")
    public String setLoginEndpointWithEmptyPassword() {
        return url + "auth/login";
    }

    @Step("I send an HTTP POST request with a valid email and an empty password")
    public void sendLoginRequestWithEmptyPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "larasati@gmail.com");
        requestBody.put("password", " ");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .contentType("application/json")
                .body(requestBody.toJSONString())
                .post(setLoginEndpointWithEmptyPassword());
    }

    @Step("I receive a valid login HTTP response code 400 Bad Request for empty password")
    public void validateLogin400ForEmptyPassword() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
