package com.restclient.resetserver;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.SSLSocketFactory;
 import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import  io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import  io.restassured.internal.path.json.JSONAssertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
//import org.hamcrest.Matchers.equalTo;
public class PostsRestTest extends com.restclient.resetserver.FunctionalTest {


    @Test
    public  void doGetRequest( ) {
        RestAssured.defaultParser = Parser.JSON;

        Response response = given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().get("https://jsonplaceholder.typicode.com/users").
                then().contentType(ContentType.JSON).extract().response();



        List<String> jsonResponse = response.jsonPath().getList("$");

        System.out.println(jsonResponse.size());

        String usernames = response.jsonPath().getString("username");
        System.out.println(usernames);

        String usernames1 = response.jsonPath().getString("username[0]");
        System.out.println(usernames1);

        List<String> jsonResponse1 = response.jsonPath().getList("username");
        System.out.println(jsonResponse1.get(0));

    }

    @Test
    public void basicPingTest() {
        RestAssured.port = 443;
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
       // RestAssured.basePath = "/posts";
        // RestAssured.useRelaxedHTTPSValidation();
        RestAssuredConfig rac = null;



        try {

            SSLContext sslContext = SSLContexts.custom().useSSL().build();
            //SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new X509TrustManager[]{new com.restclient.HttpsTrustManager()}, new SecureRandom());
           // SSLSocketFactory factory = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            //  rac = RestAssured.config().sslConfig(SSLConfig.sslConfig().sslSocketFactory(factory));

            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            rac = RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation("TLSv1.2"));
            RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));


            //  rac = RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation("TLSv1.2"));

            RestAssured.config.getHttpClientConfig().reuseHttpClientInstance();




            Response response =
                    given().config(rac).
                            formParam("title", "foo").
                            when().
                            put("/posts/1");

            System.out.print(response.asString());
            response.then().
                    body("title", equalTo("foo")).
                    statusCode(200);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        /* try {
            System.out.println("RestAssured.baseURI" + RestAssured.baseURI);
            System.out.println("RestAssured.port" + RestAssured.port);
            System.out.println("RestAssured.basePath" + RestAssured.basePath);

            // Use our custom socket factory
          //  SSLContext sslContext = SSLContexts.custom().useSSL().build();
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, new X509TrustManager[]{new com.restclient.HttpsTrustManager()}, new SecureRandom());
            org.apache.http.conn.ssl.SSLSocketFactory customSslFactory = new com.restclient.Sslv3SocketFactory(
                    sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            rac = RestAssured.config().sslConfig(
                    SSLConfig.sslConfig().sslSocketFactory(customSslFactory));

            RestAssured.config.getHttpClientConfig().reuseHttpClientInstance();
               RestAssured.given().config(rac).when().get("https://reqres.in/api/users/2").then().statusCode(200);
             System.out.println("here");
        } catch (Exception e) {
             System.out.println("there");
            e.printStackTrace();
        }*/

        // RestAssuredConfig rac = RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames().relaxedHTTPSValidation("TLSv1.2"));

        /* try {
             RestAssured.get("https://reqres.in/api/users/2").then().spec(helloWorldSpec());
           // RestAssured.given().config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation())).when().get("https://reqres.in/api/users/2").then().spec(helloWorldSpec());
        }
        catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            RestAssured.reset();
        }
*/
       /* RestAssured.given()
                .config(RestAssured.config().sslConfig(
                        new SSLConfig().allowAllHostnames())).when().get("/posts").then().statusCode(200);;

        //RestAssured.given().config(rac).when().get("/posts").then().statusCode(200);
        // RestAssured.given().relaxedHTTPSValidation("TLSv1.2").when().get("/posts").then().statusCode(200);

*/

    }



}