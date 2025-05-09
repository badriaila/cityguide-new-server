package com.example.cityguideserver.middleware;

public class LocationData {
    private int locationID;
    private String locationName;
    private double locationLat;
    private double locationLong;
    private String beaconTableName;
    private String beaconDataTableName;
    private String feedbackTableName;

    public LocationData(int locationID, String locationName, double locationLat, double locationLong, String beaconTableName, String beaconDataTableName, String feedbackTableName) {
        this.locationID = locationID;
        this.locationName = locationName;
        this.locationLat = locationLat;
        this.locationLong = locationLong;
        this.beaconTableName = beaconTableName;
        this.beaconDataTableName = beaconDataTableName;
        this.feedbackTableName = feedbackTableName;
    }

    public int getLocationID() { return locationID; }
    public String getLocationName() { return locationName; }
    public double getLocationLat() { return locationLat; }
    public double getLocationLong() { return locationLong; }
    public String getBeaconTableName() { return beaconTableName; }
    public String getBeaconDataTableName() { return beaconDataTableName; }
    public String getFeedbackTableName() { return feedbackTableName; }

}


