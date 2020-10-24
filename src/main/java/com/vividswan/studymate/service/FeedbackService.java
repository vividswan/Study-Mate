package com.vividswan.studymate.service;

import com.vividswan.studymate.dto.FeedbackCreateDto;
import com.vividswan.studymate.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Transactional
    public void createFeedback(FeedbackCreateDto feedbackCreateDto) {
        feedbackRepository.createReply(feedbackCreateDto.getUserId(), feedbackCreateDto.getUserId(), feedbackCreateDto.getContent());
    }

    @Transactional
    public void deleteFeedback(long id) {
        feedbackRepository.deleteById(id);
    }
}
