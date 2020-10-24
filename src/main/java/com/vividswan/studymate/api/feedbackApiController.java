package com.vividswan.studymate.api;

import com.vividswan.studymate.dto.FeedbackCreateDto;
import com.vividswan.studymate.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FeedbackApiController {

    private final FeedbackService feedbackService;


    @PostMapping("/api/task/create")
    int createFeedback(@RequestBody FeedbackCreateDto feedbackCreateDto){
       feedbackService.createFeedback(feedbackCreateDto);
        return HttpStatus.OK.value();
    }
}
