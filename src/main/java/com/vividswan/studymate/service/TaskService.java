package com.vividswan.studymate.service;

import com.vividswan.studymate.dto.TaskWriteDto;
import com.vividswan.studymate.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public void write(TaskWriteDto taskWriteDto){
        taskRepository.save(taskWriteDto.toEntity());
    }
}
