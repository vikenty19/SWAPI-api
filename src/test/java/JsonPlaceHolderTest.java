import config.BaseTest;
import org.junit.Test;

import static constants.Constants.Actions.*;
import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTest extends BaseTest {
   @Test
    public void getInfo(){
        given().queryParam("postId",1).log().uri()
                .when().get(JSON_PLACEHOLDER_GET)
                .then().spec(responseSpecGet).log().body();

    }
    @Test
    public void putInfo(){

        String jsonBody ="{\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "}";
        given().body(jsonBody).log().all()
                .when().put(JSON_PLACEHOLDER_PUT)
                .then().log().body().statusCode(200);
    }   @Test
    public void postInfo(){

        String jsonBody ="{\n" +
                "\"id\":1,\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1\n" +
                "}";
        given().body(jsonBody).log().all()
                .when().post(JSON_PLACEHOLDER_POST)
                .then().spec(responseSpecPost).log().body();
    }
}
