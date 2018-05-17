package  com.restclient.resetserver;

import com.commons.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.*;
import org.testng.*;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.*;

import org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.expect;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.both;

//import org.hamcrest.Matchers.equalTo;
import org.junit.Test;

import org.junit.Test;
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