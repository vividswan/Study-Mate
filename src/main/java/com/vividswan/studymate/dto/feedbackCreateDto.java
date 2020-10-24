package com.vividswan.studymate.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class FeedbackCreateDto {
    private long userId;
    private long taskId;
    private String content;

    @Builder
    FeedbackCreateDto(long userId, long taskId, String content){
        this.userId = userId;
        this.taskId = taskId;
        this.content = content;
    }
}
