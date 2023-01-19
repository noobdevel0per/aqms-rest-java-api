package unitTest;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class testingPOST {

    //Send/Post data using JSON File
    @Test
    public void post_Req(){
        //File object to import dummydata.json file
        File file = new File("src/main/resources/dummydata.json");

        given()
                .baseUri("http://localhost:8081")
                .contentType(ContentType.JSON)
                .body(file)
                .when()
                .post("/save")
                .then()
                .statusCode(200);
    }
    //Posting data with json OBJECT

    @Test
    public void post_by_object() throws JSONException {
        JSONObject body = new JSONObject();
        body.put("floor","3");
        body.put("co2","302");
        body.put("c","220");
        body.put("co","120");
        body.put("so2","550");
        body.put("o2","50");

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
