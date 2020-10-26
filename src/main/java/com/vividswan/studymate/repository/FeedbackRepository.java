package com.vividswan.studymate.repository;

import com.vividswan.studymate.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {


    @Modifying
    @Query(value = "INSERT INTO feedback(userId, taskId, content, createDate) VALUES(?1, ?2, ?3, now())",nativeQuery = true)
    void createReply(long userId, long taskId, String content);
}
