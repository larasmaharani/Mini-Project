package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginPositive {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoint for login")
    public String setLoginEndpoint() {
        return url + "auth/login";
    }

    @Step("I send an HTTP POST request with valid email and password")
    public void sendValidLoginRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "larasati@gmail.com");
        requestBody.put("password", "password");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .contentType("application/json")
                .body(requestBody.toJSONString())
                .post(setLoginEndpoint());
    }

    @Step("I receive a valid data login HTTP response code 200 OK")
    public void validateLogin200() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
