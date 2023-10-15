import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class testToken {
    @Test
    public void testTokenJob() {
        JsonPath response = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath ();
        String newtoken = response.get("token");

        System.out.println(newtoken);

        Map<String, String> data = new HashMap<>();
        data.put ("token", newtoken);
        Response responseWithToken = RestAssured
                .given()
                .body(data)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
        response.prettyPrint();



    }
}
