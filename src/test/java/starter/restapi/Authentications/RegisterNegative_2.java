package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class RegisterNegative_2 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set an invalid baseURL POST endpoint for registration")
    public String getNegative2RegisterEndpoint() {
        return url + "auth/registe";
    }

    @Step("I send an invalid baseURL HTTP POST request with valid email, password, and fullname")
    public void sendNegative2PostHTTPRegister() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "larasati@mail.com");
        requestBody.put("password", "password");
        requestBody.put("fullname", "Firstname Lastname");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .contentType("application/json")
                .post(getNegative2RegisterEndpoint());
    }

    @Step("I receive a valid data register HTTP response code 404 Bad Request")
    public void validateNegative2Register() {
        restAssuredThat(response -> response.statusCode(404));
    }

}
