package starter.restapi.Products;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetCommentProductsNegative {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set GET invalid comment endpoints")
    public String GetInvalidCommentEndpoints(){
        return url + "product/2/comments";

    }
    @Step("I send HTTP GET request for comment products")
    public void commentHTTPGetRequest(){
        RestAssured.defaultParser = Parser.JSON;
        SerenityRest.given()
                .accept("text/plain")
                .when()
                .get(GetInvalidCommentEndpoints());

    }
    @Step("I receive valid comment HTTP response code 404 Not Found")
    public void HTTPCommentResponse404(){
        restAssuredThat(response ->response.statusCode(404));
        restAssuredThat(response -> response.body("$", notNullValue()));
    }

    @Step("I don't receive valid data for comment products")
    public void emptyCommentData() {
        restAssuredThat(response -> response.body("$", notNullValue()));
    }
}
