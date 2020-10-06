package com.vividswan.studymate.repository;

import com.vividswan.studymate.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task ,Long> {
    List<Task> findAllByUserId(Long userId);
}
