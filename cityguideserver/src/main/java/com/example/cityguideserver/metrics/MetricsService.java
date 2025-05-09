package com.example.cityguideserver.metrics;


import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Timer;

@Service
public class MetricsService {

    private final Timer feedbackResponseTimer;


    @Autowired
    public MetricsService(MeterRegistry meterRegistry){
        this.feedbackResponseTimer = meterRegistry.timer("feedback_request_response_time");
    }

    public void recordFeedbackResponseTime(long startTime){

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        feedbackResponseTimer.record(duration, java.util.concurrent.TimeUnit.MILLISECONDS);
    }


}
