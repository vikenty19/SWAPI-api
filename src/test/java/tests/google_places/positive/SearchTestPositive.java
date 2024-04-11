package tests.google_places.positive;

import api.api_manager.ApiManager;
import base.BaseTest;
import io.restassured.http.Method;
import models.google_places.GooglePlacesModel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTestPositive extends BaseTest {
    @Test(description = "search some object",dataProvider = "")
            public void searchObjectWithText(String key,String input,String inputtype) {
        GooglePlacesModel.RequestModel requestModel = GooglePlacesModel.RequestModel.builder()
                .key(key)
                .input(input)
                .inputtype(inputtype)
                .build();
        apiManager.getGooglePlacesModel().search(requestModel, Method.GET,200);
    }
    @DataProvider
    public Object [][] searchText(){
        return new Object[][]{
                {"","new york","textquerry"}
        };

    }
}
