package automaticDataSender;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class dataSender {

    @Test
    public void post_by_object() throws JSONException {
        JSONObject body = new JSONObject();
        body.put("floor","1");
        body.put("co2","02");
        body.put("c","220");
        body.put("co","20");
        body.put("so2","50");
        body.put("o2","33");

        given()
                .baseUri("http://localhost:8081")
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when()
                .post("/save")
                .then()
                .statusCode(200);
    }
}
