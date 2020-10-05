package com.vividswan.studymate.api;

import com.vividswan.studymate.dto.UserJoinDto;
import com.vividswan.studymate.dto.UserUpdateDto;
import com.vividswan.studymate.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/joinProc")
    public int joinProc(@RequestBody UserJoinDto userJoinDto){
        userService.join(userJoinDto);
        return HttpStatus.OK.value();
    }

    @PutMapping("/api/userProc/{userId}")
    public int update(@RequestBody UserUpdateDto userUpdateDto, @PathVariable Long userId){
        userService.update(userId, userUpdateDto);
        return HttpStatus.OK.value();
    }
}
