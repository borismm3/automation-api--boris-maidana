package testSuite.todoly;

import endpoints.ItemsEndpoints;
import endpoints.TokenEndpoint;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    TokenEndpoint tokenEndpoint;
    String token;
    ItemsEndpoints itemsEndpoints;


    @BeforeEach
    public void getToken() {
        token = TokenEndpoint.token();
    }

}
