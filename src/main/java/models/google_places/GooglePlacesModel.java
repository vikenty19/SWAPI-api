package models.google_places;

import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import utils.NetworkCore;

import java.util.HashMap;
import java.util.Map;

import static constans.Constants.EndPoint.GOOGLE_PLACES_ENDPOINT_SEARCH;
import static constans.Constants.Path.GOOGLE_PLACES_PATH;
import static constans.Constants.ServerName.GOOGLE_PLACES_SEVER;

public class GooglePlacesModel extends NetworkCore {
    @Setter
    @Getter
    @Builder
    public static class RequestModel {
        private String key;
        private String input;
        private String inputtype;
    }

    public GooglePlacesModel search(RequestModel model, Method method, int statusCode) {
        Map<String, String> requestedParams = new HashMap<>();
        requestedParams.put("key", model.getKey());
        requestedParams.put("input", model.getInput());
        requestedParams.put("inputtype", model.getInputtype());
        requestSpecBuilder.setBaseUri(GOOGLE_PLACES_SEVER + GOOGLE_PLACES_PATH +GOOGLE_PLACES_ENDPOINT_SEARCH)
                .addQueryParams(requestedParams);
        sendRequestAndGetResponse(Method.GET,200);
       return this;
    }

}
