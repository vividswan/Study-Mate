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
    public boolean joinProc(@RequestBody UserJoinDto userJoinDto){
        boolean valid =  userService.join(userJoinDto);
        return valid;
    }

    @PutMapping("/api/userProc/{userId}")
    public int update(@RequestBody UserUpdateDto userUpdateDto, @PathVariable Long userId){
        userService.update(userId, userUpdateDto);
        return HttpStatus.OK.value();
    }

}
