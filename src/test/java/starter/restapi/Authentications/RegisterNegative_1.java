package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class RegisterNegative_1 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the Register with duplicate email POST endpoint for registration")
    public String getNegative1RegisterEndpoint() {
        return url + "auth/register";
    }

    @Step("I send an Register with duplicate email HTTP POST request with valid email, password, and fullname")
    public void sendNegative1PostHTTPRegister() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "larasati@mail.com");
        requestBody.put("password", "password");
        requestBody.put("fullname", "Firstname Lastname");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .contentType("application/json")
                .post(getNegative1RegisterEndpoint());
    }

    @Step("I receive a valid data register HTTP response code 400 Bad Request")
    public void validateNegative1Register() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
