package com.vividswan.studymate.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Lob
    private String content;

    @CreationTimestamp
    private LocalDateTime createDate;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    private int isSuccess;
}
