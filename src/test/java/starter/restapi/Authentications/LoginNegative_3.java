package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
    public class LoginNegative_3 {
        protected String url = "https://altashop-api.fly.dev/api/";

        @Step("I set the POST endpoint for login with unregistered user")
        public String setLoginEndpointForUnregisteredUser() {
            return url + "auth/login";
        }

        @Step("I send an HTTP POST request with valid email, password, and script test for login")
        public void sendLoginRequestWithScriptTest() {
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "laraslaras@gmail.com");
            requestBody.put("password", "password");

            SerenityRest
                    .given()
                    .header("Authorization","application/json")
                    .post(setLoginEndpointForUnregisteredUser());
        }

        @Step("I receive a valid data create new login HTTP response code 400 Bad Request")
        public void validateLogin400ForUnregisteredUser() {
            restAssuredThat(response -> response.statusCode(400));
        }
    }

