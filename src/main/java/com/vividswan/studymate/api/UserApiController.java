package com.vividswan.studymate.api;

import com.vividswan.studymate.dto.UserJoinDto;
import com.vividswan.studymate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/joinProc")
    public int joinProc(@RequestBody UserJoinDto userJoinDto){
        userService.join(userJoinDto);
        return HttpStatus.OK.value();
    }
}
