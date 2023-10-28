package starter.restapi.Hello;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class HelloNegative_1 {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set GET Hello Wrong Endpoint")
    public String setHelloApiEndpoint2() {

        return url + "hai";
    }

    @Step("I send GET Hello HTTP request invalid URL")
    public void setWrongHelloHttpGet() {
        SerenityRest.given()
                .when()
                .get(setHelloApiEndpoint2());
    }

    @Step("I receive valid HTTP response code 404")
    public void validateHelloHttpResponseCode404() {

        restAssuredThat(response -> response.statusCode(404));
    }

}