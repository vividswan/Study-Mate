package com.vividswan.studymate.controller;

import com.vividswan.studymate.dto.UserJoinDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("join")
    public String joinForm(){
        return "user/joinForm";
    }

}
