package starter.restapi.Hello;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class HelloNegative_2 {
    protected static String url = "https://altashop-api.fly.dev/api/";

    @Step("I set POST Hello Endpoint")
    public String setWrongHelloEndpoint(){
        return url + "hello";
    }

    @Step("I send POST Hello Endpoint Request")
    public void sendPostHttpRequest2(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1);
        requestBody.put("title", "Lalala");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .post(setWrongHelloEndpoint());
    }

    @Step("I receive valid HTTP response code 405")
    public void receivePostHelloHttpResponseCode405(){
        restAssuredThat(response -> response.statusCode(405));
    }
}
