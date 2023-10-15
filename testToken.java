import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class testToken {
    @Test
    public void testTokenJob() throws InterruptedException {
        JsonPath response = RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath ();
        String newtoken = response.get("token");

        Map<String, String> data = new HashMap<>();
        data.put ("token", newtoken);
        Response responseWithToken = RestAssured
                .given()
                .params(data)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
        responseWithToken.prettyPrint();
        Thread.sleep(16000);

        Map<String, String> data2 = new HashMap<>();
        data.put ("token", newtoken);
        Response responseEndOfJob = RestAssured
                .given()
                .params(data)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .andReturn();
        responseEndOfJob.prettyPrint();

    }
}
