package com.vividswan.studymate.dto;

import com.vividswan.studymate.model.Task;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class TaskWriteDto {

    private String title;
    private String content;
    private Timestamp deadline;

    @Builder
    public TaskWriteDto(String title, String content, Timestamp deadline){
        this.title = title;
        this.content = content;
        this.deadline = deadline;
    }

    public Task toEntity(){
        return Task.builder()
                .title(title)
                .content(content)
                .deadline(deadline)
                .build();
    }
}
