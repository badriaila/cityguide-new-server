package com.example.cityguideserver.repository;

import com.example.cityguideserver.model.Feedback;

public interface FeedbackRepository {
    void saveFeedback(String tablename, Feedback feedback);
}
