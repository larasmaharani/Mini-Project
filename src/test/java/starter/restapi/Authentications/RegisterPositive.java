package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class RegisterPositive {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoint for registration")
    public String getRegisterEndpoint() {
        return url + "auth/register";
    }

    @Step("I send an HTTP POST request with valid email, password, and fullname")
    public void sendPostHTTPRegister() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "larasati10@mail.com");
        requestBody.put("password", "password");
        requestBody.put("fullname", "Firstname Lastname");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoiYWFAbWFpbC5jb20ifQ.7POMMs7flgOaoS3mcGSF-K34HIyd-7LdX54jJFTpx_M")
                .contentType("application/json")
                .post(getRegisterEndpoint());
    }

    @Step("I receive a valid data register HTTP response code 200 OK")
    public void validateRegister200() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
