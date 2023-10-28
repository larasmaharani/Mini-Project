package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginNegative_1 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoint for user login with empty body")
    public String setLoginEndpointWithEmptyBody() {
        return url + "auth/login";
    }

    @Step("I send an HTTP POST request with an empty body for Login")
    public void sendLoginRequestWithEmptyBody() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .contentType("application/json")
                .post(setLoginEndpointWithEmptyBody());
    }

    @Step("I receive a valid login HTTP response code 400 Bad Request for empty body")
    public void validateLogin400ForEmptyBody() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
