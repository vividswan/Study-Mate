package com.vividswan.studymate.repository;

import com.vividswan.studymate.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
