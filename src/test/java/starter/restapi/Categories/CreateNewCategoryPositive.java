package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewCategoryPositive {
    protected String url = "https://altashop-api.fly.dev/api/";

    @Step("I set the POST endpoint for creating a category")
    public String setCategoryApiEndpoint() {
        return url + "categories";
    }

    @Step("I send an HTTP POST request with a valid name and description")
    public void sendPostRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "gaming");
        requestBody.put("description", "for gaming purposes");

        SerenityRest.given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoibGFyYXNAZ21haWwuY29tIn0.LmAVhvyywRP3Z6zHgKLdYDudNUSrEKIKQYphFX78zOo").body(requestBody.toJSONString()).post(setCategoryApiEndpoint());
    }

    @Step("I receive a valid category creation HTTP response code 200 OK")
    public void validateCategoryCreationResponseCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
