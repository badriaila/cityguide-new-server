package com.example.cityguideserver.service;
import com.example.cityguideserver.middleware.LocationData;
import com.example.cityguideserver.middleware.TableSelection;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;


@Service
public class LocationService {

    private static final List<LocationData> LOCATIONS = Arrays.asList(
            new LocationData(1, "Wichita State University", 37.71, 97.29, "wallacehallBeacons", "wallacehallBeaconData", "wallacehallFeedback"),
            new LocationData(2, "Envision HQ", 37.69, 97.33, "envisionBeacons", "envisionBeaconData", "envisionFeedback"),
            new LocationData(3, "Envision Art Gallery", 37.68, 97.32, "envisionBeacons", "envisionBeaconData", "envisionFeedback"),
            new LocationData(4, "Lehigh University", 40.61, 75.37, "hstBeacons", "hstBeaconData", "hstFeedback"),
            new LocationData(5, "Temp Location", 36.33, 94.26, "tamuBeacons", "tamuBeaconData", "tamuFeedback"),
            new LocationData(6, "Texas A&M University", 30.62, 96.33, "tamuBeacons", "tamuBeaconData", "tamuFeedback")
    );

    public TableSelection determineLocation(double latitude, double longitude) {
        double lat = Math.round(latitude * 100.0) / 100.0;
        double lon = Math.round(longitude * 100.0) / 100.0;



        return getLocationName(lat, lon);
    }

    public static TableSelection getLocationName(double lat, double lon) {

        for(LocationData location: LOCATIONS) {
            if (location.getLocationLat() == lat && location.getLocationLong() == lon) {
                return new TableSelection(
                        location.getBeaconTableName(),
                        location.getBeaconDataTableName(),
                        location.getFeedbackTableName()
                );
            }
        }

        return new TableSelection("", "", "");
    }
}
