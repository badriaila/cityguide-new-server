package com.example.cityguideserver.dto;

import com.example.cityguideserver.model.Feedback;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.antlr.v4.runtime.misc.NotNull;

public class FeedbackRequest {

    @NotNull
    @JsonProperty("long")
    private double longitude;

    @NotNull
    @JsonProperty("lat")
    private double latitude;

    @NotNull
    private String date;

    @Min(1)
    @Max(5)
    private int stars;

    @NotNull
    private String comment;

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getStars() {
        return stars;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

}
