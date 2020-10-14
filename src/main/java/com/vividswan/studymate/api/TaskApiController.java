package com.vividswan.studymate.api;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import com.vividswan.studymate.dto.TaskUpdateDto;
import com.vividswan.studymate.dto.TaskWriteDto;
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

    @PutMapping("/api/taskUpdate/{id}")
    public int update(@PathVariable long id, @AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody TaskUpdateDto taskUpdateDto){
        taskService.update(id, taskUpdateDto);
        return HttpStatus.OK.value();
    }

    @PutMapping("/api/taskSuccess/{id}")
    public int updateSuccess(@RequestBody int isSuccess , @PathVariable long id){
        taskService.updateSuccess(id, isSuccess);
        return HttpStatus.OK.value();
    }
}
