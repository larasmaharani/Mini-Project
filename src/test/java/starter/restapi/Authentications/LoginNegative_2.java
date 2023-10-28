package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LoginNegative_2 {
    protected String url = "https://altashop-api.fly.dev/api/";

        @Step("I set the Login with invalid baseURL POST endpoint for login")
        public String setInvalidBaseUrlForLogin() {
            return url + "auth/logi";
        }

        @Step("I send Login with invalid baseURL HTTP POST request with valid email and password")
        public void sendLoginRequestWithInvalidBaseUrl() {
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "larasati@gmail.com");
            requestBody.put("password", "123123");

            SerenityRest
                    .given()
                    .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                    .contentType("application/json")
                    .post(setInvalidBaseUrlForLogin());
        }

        @Step("I receive a valid data create new login HTTP response code 404 Not Found")
        public void validateLogin404() {
            restAssuredThat(response -> response.statusCode(404));
        }

    }
