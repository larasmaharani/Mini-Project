package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewCategoryNegative_3 {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set an invalid POST endpoint for creating a category")
    public String setInvalidCategoryApiEndpoint2() {
        return url + "categorie";
    }

    @Step("I send an category HTTP POST request with a valid name and description")
    public void sendPostRequestWithValidDataToInvalidEndpoint2() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "gaming");
        requestBody.put("description", "for gaming purposes");

        SerenityRest
                .given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo")
                .contentType("application/json")
                .post(setInvalidCategoryApiEndpoint2());
    }

    @Step("I receive for product category with a valid HTTP response code 404 Not Found")
    public void validateInvalidCategoryResponseCode404_2() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
