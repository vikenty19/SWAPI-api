package constants;

import static constants.Constants.Server.JSON_PLACEHOLDER;

public class Constants {
    public static class RunVariable{
        public static String server =  JSON_PLACEHOLDER;
        public static String path ="";

    }
    public static class Server{
        public static String SWAPI_URL = "https://swapi.dev/";
        public static String JSON_PLACEHOLDER ="https://jsonplaceholder.typicode.com/";
        public static String GOOGLE_PLACES_URL;
    }
    public static class Path{
        public static String SWAPI_PATH = "api/";

        public static String GOOGLE_PLACES_PATH;
    }
    public static class Actions{
        //swapi
        public static String SWAPI_GET_PEOPLE = "people/";
        //Google places
        public static String GOOGLE_PLACES_PATH;
        //JsonPlaceHolder
        public static String JSON_PLACEHOLDER_GET = "comments/";
        public static String JSON_PLACEHOLDER_PUT = "posts/1";
        public static String JSON_PLACEHOLDER_POST = "posts/";
    }
}
