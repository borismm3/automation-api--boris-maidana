package testSuite.todoly;

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import endpoints.ItemsEndpoints;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CRUDItemTest extends TestBase {
    @Test
    public void verifyCrudItem() {
        JSONObject body = new JSONObject();
        body.put("Content", "MOJIX");
        itemsEndpoints = new ItemsEndpoints(token);
        itemsEndpoints.baseUrl();
        int id = itemsEndpoints.createItem(body.toString()).then().extract().path("Id");
        body.put("Content", "UPDATE");
        itemsEndpoints.getItem(id);
        itemsEndpoints.updateItem(id, body.toString());
        itemsEndpoints.deleteItem(id);
    }
}
