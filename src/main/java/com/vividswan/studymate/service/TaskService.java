package com.vividswan.studymate.service;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import com.vividswan.studymate.dto.TaskWriteDto;
import com.vividswan.studymate.model.Task;
import com.vividswan.studymate.model.User;
import com.vividswan.studymate.repository.TaskRepository;
import com.vividswan.studymate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Transactional
    public void write(TaskWriteDto taskWriteDto, PrincipalDetails principalDetails){
        User findUser = userRepository.findByUsername(principalDetails.getUsername()).orElseThrow(()->{
            return new IllegalArgumentException("해당 사용자를 찾을 수 없습니다.");
        });
        taskWriteDto.setUser(findUser);
        taskWriteDto.setIsSuccess(0);
        taskWriteDto.setStringDeadline(taskWriteDto.getDeadline().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm")));
        taskRepository.save(taskWriteDto.toEntity());
    }

    @Transactional(readOnly = true)
    public Page<Task> findList(PrincipalDetails principalDetails, Pageable pageable) {
        return taskRepository.findAllByUserIdAndIsSuccess(principalDetails.getUserId(),0, pageable);
    }


    @Transactional(readOnly = true)
    public Task findTask(long id) {
        Task requestTask = taskRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 task를 찾을 수 없습니다");
        });
        return requestTask;
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }
}
