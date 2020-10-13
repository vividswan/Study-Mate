package com.vividswan.studymate.api;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import com.vividswan.studymate.dto.TaskWriteDto;
import com.vividswan.studymate.model.Task;
import com.vividswan.studymate.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TaskApiController {

    private final TaskService taskService;

    @PostMapping("api/writeProc")
    public int write(@RequestBody TaskWriteDto taskWriteDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        taskService.write(taskWriteDto, principalDetails);
        return HttpStatus.OK.value();
    }

    @DeleteMapping("/api/taskDelete/{id}")
    public int delete(@PathVariable long id){
        taskService.delete(id);
        return HttpStatus.OK.value();
    }
}
