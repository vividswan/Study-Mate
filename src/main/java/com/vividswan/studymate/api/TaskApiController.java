package com.vividswan.studymate.api;

import com.vividswan.studymate.dto.TaskWriteDto;
import com.vividswan.studymate.model.Task;
import com.vividswan.studymate.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskApiController {

    private final TaskService taskService;

    @PostMapping("api/writeProc")
    public int write(@RequestBody TaskWriteDto taskWriteDto){
        taskService.write(taskWriteDto);
        return HttpStatus.OK.value();
    }
}
