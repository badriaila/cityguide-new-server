package com.example.cityguideserver.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String date;
    private int stars;
    private String comment;

    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public int getStars(){
        return stars;
    }
    public void setStars(int stars){
        this.stars = stars;
    }

    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }

}
