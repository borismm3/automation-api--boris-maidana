package endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TokenEndpoint {
    public static String token () {
        Response response = given()
                .auth()
                .preemptive()
                .basic("boris@gmail.com", "123456")
                .log().all()
        .when()
                .get("https://todo.ly/api/authentication/token.json");

        response.then()
                .log().all()
                .statusCode(200);

        return response.then().extract().path("TokenString");
    }
}
