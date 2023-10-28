package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreateNewCategoryNegative_2 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoint to Create a new category for creating a category")
    public String setCategoryApiEndpoint2() {
        return url + "categories";
    }

    @Step("I send an HTTP POST request with an empty body")
    public void sendPostRequestWithEmptyBody() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .contentType("application/json")
                .post(setCategoryApiEndpoint2());
    }

    @Step("I receive a valid HTTP for product category with response code 400 Bad Request")
    public void validateCategoryResponseCode400() {
        restAssuredThat(response -> response.body("$", notNullValue()));
        restAssuredThat(response -> response.statusCode(400));
    }
}
