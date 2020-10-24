package com.vividswan.studymate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FeedbackCreateDto {
    private long userId;
    private long taskId;
    private String content;
}
