package com.vividswan.studymate.repository;

import com.vividswan.studymate.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task ,Long> {
    Page<Task> findAllByUserIdAndIsSuccess(Long userId, int isSuccess, Pageable pageable);
}
