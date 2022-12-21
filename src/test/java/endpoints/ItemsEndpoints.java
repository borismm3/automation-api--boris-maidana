package endpoints;

import config.APIConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class ItemsEndpoints {
    private static String token;

    public ItemsEndpoints(String token) {
        ItemsEndpoints.token = token;
    }

    public static void baseUrl() {
        RestAssured.baseURI = APIConstants.Items.BASE_URL;
    }

    public void getItem(int id) {
        RestAssured
        .given()
                .header("Token", token)
                .log().all()
        .when()
                .get(APIConstants.ItemsEndpoints.itemsGet(id));
    }

    public Response createItem(String body) {
        Response response = RestAssured
                .given()
                .header("Token", token)
                .body(body)
                .log().all()
        .when()
                .post(APIConstants.ItemsEndpoints.itemPost);

        response.then()
                .log().all()
                .statusCode(200)
                .body("Content", equalTo("MOJIX"));

        return response;
    }

    public Response updateItem(int id, String bodyUpdate) {
        Response response = RestAssured
                .given()
                .header("Token", token)
                .body(bodyUpdate)
                .log().all()
        .when()
                .put(APIConstants.ItemsEndpoints.itemsPut(id));

        response.then()
                .log().all()
                .statusCode(200)
                .body("Content", equalTo("UPDATE"));

        return response;
    }

    public Response deleteItem(int id) {
        Response response = RestAssured
                .given()
                .header("Token", token)
                .log().all()
        .when()
                .delete(APIConstants.ItemsEndpoints.itemsDelete(id));

        response.then()
                .log().all()
                .statusCode(200)
                .body("Deleted", equalTo(true));

        return response;
    }
}
