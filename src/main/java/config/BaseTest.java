package config;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.matcher.DetailedCookieMatcher;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.hamcrest.Matcher;
import org.junit.BeforeClass;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static constants.Constants.Path.SWAPI_PATH;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Server.SWAPI_URL;

public class BaseTest {
    protected RequestSpecification specForSwapiField = new RequestSpecBuilder()
            .setBaseUri(SWAPI_URL)
            .build();
   protected static RequestSpecification specJson = new RequestSpecBuilder()
            .addCookie("NewCookie")
            .addHeader("Content-Type","application/json")
            .build();
   protected ResponseSpecification responseSpecGet = new ResponseSpecBuilder()
           .expectStatusCode(200)
           .build();
   protected ResponseSpecification responseSpecPost = new ResponseSpecBuilder()
           .expectStatusCode(201)
           .build();



@BeforeClass
    public static void setUp(){
        RestAssured.baseURI= server;
        RestAssured.basePath = path;
//RestAssured.requestSpecification = specJson;
    }
}
