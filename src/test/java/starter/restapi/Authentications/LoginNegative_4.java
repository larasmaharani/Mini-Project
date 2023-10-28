package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginNegative_4 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoint for user login with empty email")
    public String setLoginEndpointWithEmptyEmail() {
        return url + "auth/login";
    }

    @Step("I send an HTTP POST request with a empty email and valid password")
    public void sendLoginRequestWithEmptyEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", " ");
        requestBody.put("password", "123123");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .contentType("application/json")
                .body(requestBody.toJSONString())
                .post(setLoginEndpointWithEmptyEmail());
    }

    @Step("I receive a valid login HTTP response code 400 Bad Request for empty email")
    public void validateLogin400ForEmptyEmail() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
