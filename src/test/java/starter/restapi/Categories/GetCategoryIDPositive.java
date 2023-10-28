package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoryIDPositive {
    protected static String url = "https://altashop-api.fly.dev/api/";
    @Step("I set the GET endpoint for retrieving a category by ID")
    public String setGetCategoryByIdEndpoint(){
        return url + "categories/29969";

    }
    @Step("I send an HTTP GET to category request with a valid category ID")
    public void sendGetRequestWithValidCategoryId(){
        SerenityRest.given()
                .when()
                .get(setGetCategoryByIdEndpoint());

    }
    @Step("I receive a valid Get category by ID HTTP response code 200 OK")
    public void validateGetCategoryByIdResponseCode200(){
        restAssuredThat(response ->response.statusCode(200));
    }

    @Step("I receive valid data for a single product by ID 29969")
    public void validDataIDCategory() {
        restAssuredThat(response -> response.body("data.ID", equalTo(29969)));
    }
}
