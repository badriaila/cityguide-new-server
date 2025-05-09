package com.example.cityguideserver.controller;


import com.example.cityguideserver.dto.FeedbackRequest;
import com.example.cityguideserver.metrics.MetricsService;
import com.example.cityguideserver.middleware.TableSelection;
import com.example.cityguideserver.model.Feedback;
import com.example.cityguideserver.service.FeedbackService;
import com.example.cityguideserver.service.LocationService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    private final MeterRegistry meterRegistry;
    private final Timer feedbackResponseTimer;


    @Autowired
    public FeedbackController(MeterRegistry meterRegistry){
        this.meterRegistry = meterRegistry;
        this.feedbackResponseTimer = Timer.builder(("feedback_request_response_time"))
                .description("Time taken to process feedback requests")
                .publishPercentileHistogram(true)
                .publishPercentiles(0.5, 0.95, 0.99)
                .register(meterRegistry);
    }

    @Autowired
    private MetricsService metricsService;

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private LocationService locationService;

    @PostMapping("/sendfeedback")
    public ResponseEntity<String> sendFeedback(@Valid @RequestBody FeedbackRequest feedbackRequest){

        Timer.Sample sample = Timer.start(meterRegistry);
        try{
            Feedback feedback = new Feedback();
            feedback.setDate(feedbackRequest.getDate());
            feedback.setStars(feedbackRequest.getStars());
            feedback.setComment(feedbackRequest.getComment());

            TableSelection selectedTables = locationService.determineLocation(feedbackRequest.getLatitude(), feedbackRequest.getLongitude());
            feedbackService.saveFeedback(selectedTables.getFeedbackTable(), feedback);
            return ResponseEntity.ok("Feedback sent successfully");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }finally {
            sample.stop(feedbackResponseTimer);
        }
    }


}
