package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class RegisterNegative_3 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the Register with empty body POST endpoint for registration")
    public String setNegative3RegisterEndpoint() {
        return url + "auth/register";
    }

    @Step("I send a Register with empty body HTTP POST request with an empty body")
    public void sendNegative3PostHTTPRegister() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .contentType("application/json")
                .post(setNegative3RegisterEndpoint());
    }

    @Step("I receive a valid HTTP response code 400 Bad Request")
    public void validateNegative3Register() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
