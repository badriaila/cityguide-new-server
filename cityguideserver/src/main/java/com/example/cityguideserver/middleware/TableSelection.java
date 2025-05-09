package com.example.cityguideserver.middleware;

public class TableSelection {

    private String beaconTable;
    private String beaconDataTable;
    private String feedbackTable;

    public TableSelection(String beaconTable, String beaconDataTable, String feedbackTable) {
        this.beaconTable = beaconTable;
        this.beaconDataTable = beaconDataTable;
        this.feedbackTable = feedbackTable;
    }

    public String getBeaconTable() {
        return beaconTable;
    }

    public String getBeaconDataTable() {
        return beaconDataTable;
    }

    public String getFeedbackTable() {
        return feedbackTable;
    }
}
