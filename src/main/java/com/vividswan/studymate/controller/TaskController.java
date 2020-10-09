package com.vividswan.studymate.controller;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import com.vividswan.studymate.model.Task;
import com.vividswan.studymate.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/taskForm")
    public String taskForm(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        String username = principalDetails.getUsername();
        model.addAttribute("username",principalDetails);
        model.addAttribute("now", LocalDateTime.now());
        return "task/taskForm";
    }

    @GetMapping("/todolist/proceeding")
    @ResponseBody
    public Page<Task> taskView(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails, @PageableDefault(size=8, sort = "deadline", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Task> tasks = taskService.findList(principalDetails, pageable);
        return tasks;
//        String username =principalDetails.getUsername();
//        String nickname = principalDetails.getNickname();
//        model.addAttribute("tasks",tasks);
//        model.addAttribute("username",username);
//        model.addAttribute("nickname",nickname);
//        return "task/taskView";
    }
}
