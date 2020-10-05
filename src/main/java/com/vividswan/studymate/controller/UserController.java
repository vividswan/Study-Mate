package com.vividswan.studymate.controller;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import com.vividswan.studymate.dto.UserJoinDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("userInfo")
    public String userInfo(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("username",principalDetails.getUsername());
        model.addAttribute("email",principalDetails.getEmail());
        model.addAttribute("nickname",principalDetails.getNickname());
        return "/user/userInfo";
    }
}
