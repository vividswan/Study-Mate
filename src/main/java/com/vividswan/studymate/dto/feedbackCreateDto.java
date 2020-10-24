package com.vividswan.studymate.dto;

import com.vividswan.studymate.model.Feedback;
import lombok.Builder;
import lombok.Setter;

@Setter
public class feedbackCreateDto {
    private long userId;
    private long taskId;
    private String content;

    @Builder
    feedbackCreateDto(long userId, long taskId, String content){
        this.userId = userId;
        this.taskId = taskId;
        this.content = content;
    }
}
