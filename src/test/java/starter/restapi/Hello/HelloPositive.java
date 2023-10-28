package starter.restapi.Hello;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class HelloPositive {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set GET Hello Endpoint")
    public String setHelloApiEndpoint() {

        return url + "hello";
    }

    @Step("I send GET Hello HTTP request")
    public void sendGetHelloHttpRequest() {
        SerenityRest.given()
                .when()
                .get(setHelloApiEndpoint());
    }

    @Step("I receive valid HTTP response code 200")
    public void validateHelloHttpResponseCode200() {

        restAssuredThat(response -> response.statusCode(200));
    }

}
