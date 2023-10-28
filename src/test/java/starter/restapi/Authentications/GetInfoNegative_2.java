package starter.restapi.Authentications;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetInfoNegative_2 {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set the GET endpoint for retrieving user information for invalid token")
    public String setGetUserInformationEndpoint2(){
        return url + "auth/info";

    }
    @Step("I send an HTTP GET request with an invalid token")
    public void sendGetUserInformationRequestWithInvalidToken(){
        SerenityRest.given()
                .when()
                .header("Content-Type", "application/json")
                .get(setGetUserInformationEndpoint2());

    }
    @Step("I receive a valid user information HTTP response code 401 Unauthorized")
    public void validateGetUser401ForInvalidToken(){
        restAssuredThat(response ->response.statusCode(401));
    }

}
