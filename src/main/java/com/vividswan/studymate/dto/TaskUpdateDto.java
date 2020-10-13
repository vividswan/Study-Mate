package com.vividswan.studymate.dto;

import com.vividswan.studymate.model.Task;
import com.vividswan.studymate.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskUpdateDto {

    private String title;
    private String content;
    private LocalDateTime deadline;
    private String stringDeadline;

    @Builder
    public TaskUpdateDto(String title, String content, LocalDateTime deadline){
        this.title = title;
        this.content = content;
        this.deadline = deadline;
    }
}
