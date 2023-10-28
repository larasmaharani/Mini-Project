package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteCategoryNegative {
    protected String url = "https://altashop-api.fly.dev/api/";
    @Step("I set an invalid DELETE endpoint for deleting a category")
    public String setInvalidDeleteCategoryEndpoint(){
        return url + "categorie/1";
    }
    @Step("I send an invalid HTTP DELETE request with a valid category ID")
    public void sendInvalidDeleteRequestWithValidCategoryId(){
        SerenityRest.given().delete(setInvalidDeleteCategoryEndpoint());
    }
    @Step("I receive a valid category delete HTTP response code 404 Not Found")
    public void validateInvalidDeleteCategoryResponseCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }
}
