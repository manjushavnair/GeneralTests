
package  com.restclient.resetserver;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

//import org.hamcrest.Matchers.equalTo;
public class PostsRestTest extends FunctionalTest{

    @Test
    public void basicPingTest() {
        given().when().get("/posts").then().statusCode(200);
    }

    @Test
    public void invalidParkingSpace() {
        given().when().get("/posts/12")
                .then().statusCode(404);
        given().when().get("/posts").then()
                .body(containsString("Acme garage"));
    }

}