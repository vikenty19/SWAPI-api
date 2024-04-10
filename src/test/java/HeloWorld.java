import config.BaseTest;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static constants.Constants.Actions.SWAPI_GET_PEOPLE;
import static constants.Constants.Path.SWAPI_PATH;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class HeloWorld extends BaseTest {
    @Test
    public void firstTest(){
        System.out.println("Hello world");
        given().log().uri()
                .when().get(SWAPI_GET_PEOPLE +"1")
                .then().log().body().statusCode(200);

    }
    @Test
    public void responseHasField(){
        given().spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH)
                .then().body("planets",equalTo("https://swapi.dev/api/planets/"))
                        .log().body().statusCode(200);
            }
    @Test
    public void responseHasFieldWithIndex(){
        given().spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE)
                .then().body("results.films[0][0]",equalTo("https://swapi.dev/api/films/1/"))
                .body("count",equalTo(82))
                .log().body().statusCode(200);
    }
    @Test
    public void getAllDataFromResponse(){
        Response response = given()
                .spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH)
                .then().extract().response();
        String jsonAsString =response.asString();
      //  String cookie = response.getCookies().toString();
        System.out.println(jsonAsString);
    }
    @Test
    public void getCookieFromResponse(){

        Response response = given()
                .spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH)
                .then().extract().response();
        response.prettyPrint();
        String cookie = response.getCookie("cfduid");
        System.out.println(cookie);
    }
    @Test
    public void getHeadersFromResponse(){
        Response response = given()
                .spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH)
                .then().extract().response();
        Headers headers = response.getHeaders();
        System.out.println("HEADERS---->\n"+ headers);
        String header = response.getHeader("Date");
        System.out.println( "Today is ----->>> " + header);
    }
    //Using Groovy to get Object info
    @Test
    public void getObjectInfoWithSomeKey(){
        Response response = given()
                .spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        Map<String,?> someObject = response
                .path("results.find{it.name='Luke_Skywalker'}");
        System.out.println("Result---->"+ someObject);

    }
    @Test
    public void getSingleElementWithSomeKey(){
        Response response =given()
                .spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
        // Get films with Luke Skywalker
       List<String> objectFilms = response.path("results.find{it.name = 'Luke_Skywalker'}.films");
        System.out.println(objectFilms);

    }
    @Test
    public void getAllElementWithSomeKey() {
        Response response = given()
                .spec(specForSwapiField).log().uri()
                .when().get(SWAPI_PATH + SWAPI_GET_PEOPLE);
     //   System.out.println(response.asPrettyString());
        //Search for the names of characters in films
        List<String> filmsNames = response
                .path("results.findAll{it.films}.name");
        System.out.println(filmsNames);
    }
}
