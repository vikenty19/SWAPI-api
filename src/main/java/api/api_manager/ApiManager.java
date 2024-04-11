package api.api_manager;

import lombok.Getter;
import lombok.Setter;
import models.google_places.GooglePlacesModel;

public class ApiManager {
    @Setter
    @Getter
    GooglePlacesModel googlePlacesModel = new GooglePlacesModel();
}
