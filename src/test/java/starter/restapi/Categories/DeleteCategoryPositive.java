package starter.restapi.Categories;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteCategoryPositive {
    protected String url = "https://altashop-api.fly.dev/api/";
    @Step("I set the DELETE endpoint for deleting a category")
    public String setDeleteCategoryEndpoint(){
        return url + "categories/1";
    }
    @Step("I send an HTTP DELETE request with a valid category ID")
    public void sendDeleteRequestWithValidCategoryId(){
        SerenityRest.given().delete(setDeleteCategoryEndpoint());
    }
    @Step("I receive a valid delete category HTTP response code 200 OK")
    public void validateDeleteCategoryResponseCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }
}
