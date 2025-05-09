package com.example.cityguideserver.service;


import com.example.cityguideserver.model.Feedback;
import com.example.cityguideserver.repository.FeedbackRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private final MeterRegistry meterRegistry;

    public FeedbackService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void saveFeedback(String tablename, Feedback feedback) {
        feedbackRepository.saveFeedback(tablename, feedback);
        meterRegistry.counter("feedback.saved", "table", tablename).increment();
    }

}
