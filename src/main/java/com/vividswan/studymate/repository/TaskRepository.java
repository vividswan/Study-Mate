package com.vividswan.studymate.repository;

import com.vividswan.studymate.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task ,Long> {
}
