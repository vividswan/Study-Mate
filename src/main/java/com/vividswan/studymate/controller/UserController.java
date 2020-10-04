package com.vividswan.studymate.controller;

import com.vividswan.studymate.dto.UserJoinDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @GetMapping("join")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("loginForm")
    public String loginForm(){
        return "user/loginForm";
    }

    @ResponseBody
    @GetMapping("userInfo")
    public String userInfo(){
        return "userInfo";
    }
}
