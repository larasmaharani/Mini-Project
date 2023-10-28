package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetInfoNegative_1 {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set the GET endpoint for retrieving user information")
    public String setInvalidGetUserInformationEndpoint(){
        return url + "auth/inf";

    }
    @Step("I send an HTTP GET request with a valid token")
    public void sendGetUserInformationRequestWithInvalidBaseURL(){
        SerenityRest.given()
                .when()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IiAiLCJFbWFpbCI6ImxhcmFzYXRpQGdtYWlsLmNvbSJ9.MabljNzw6McLeT2yj_RllLcEgjbvnnNOb4_R_bKi83E")
                .get(setInvalidGetUserInformationEndpoint());

    }
    @Step("I receive a valid user information HTTP response code 200 OK")
    public void validateGetUser400ForEmptyEmailPassword(){
        restAssuredThat(response ->response.statusCode(404));
    }

}
