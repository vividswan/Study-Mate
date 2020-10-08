package com.vividswan.studymate.controller;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import com.vividswan.studymate.model.Task;
import com.vividswan.studymate.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String taskView(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        List<Task> tasks = taskService.findList(principalDetails);
        String username =principalDetails.getUsername();
        String nickname = principalDetails.getNickname();
        model.addAttribute("tasks",tasks);
        model.addAttribute("username",username);
        model.addAttribute("nickname",nickname);
        return "task/taskView";
    }
}
