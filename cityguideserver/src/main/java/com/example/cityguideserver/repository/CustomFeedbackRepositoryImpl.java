package com.example.cityguideserver.repository;

import com.example.cityguideserver.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomFeedbackRepositoryImpl implements FeedbackRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveFeedback(String tablename, Feedback feedback){
        String query = "INSERT INTO " + tablename + " (date, stars, comment) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, feedback.getDate(), feedback.getStars(), feedback.getComment());
    }
}
