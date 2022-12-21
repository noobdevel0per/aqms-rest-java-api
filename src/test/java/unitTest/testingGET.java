package unitTest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class testingGET {
    //To check if API is sending data or not
    @Test
    public void getReq() {
        given()
                .baseUri("http://localhost:8081").when()
                .get("/data").then().statusCode(200);
    }

    //To check if the JSON fetched is correct as required
    @Test
    public void validate_json_response() {
        given()
                .baseUri("http://localhost:8081").when()
                .get("/data/1").then().statusCode(200)
                .body("id",equalTo(1),
                        "floor",equalTo(1));
    }

    //To check weather we are getting data or not
    @Test
    public void extract_data(){
        Response res =given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/data")
                .then().extract().response();
        System.out.println(res.asString());
    }
}
