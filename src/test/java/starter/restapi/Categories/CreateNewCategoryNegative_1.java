package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewCategoryNegative_1 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set an invalid Create a new category POST endpoint for creating a category")
    public String setInvalidCategoryApiEndpoint() {
        return url + "categorie";
    }

    @Step("I send an invalid HTTP POST request with empty")
    public void sendPostRequestWithValidDataToInvalidEndpoint() {
        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .contentType("application/json")
                .post(setInvalidCategoryApiEndpoint());
    }

    @Step("I receive a valid HTTP for product category with response code 404 Not Found")
    public void validateInvalidCategoryResponseCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }

}
