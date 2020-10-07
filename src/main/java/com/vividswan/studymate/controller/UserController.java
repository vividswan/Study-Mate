package com.vividswan.studymate.controller;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("join")
    public String joinForm(){
        return "user/joinForm";
    }

    @GetMapping("loginForm")
    public String loginForm(Model model, int first)
    {
        boolean chk;
        if(first==1){
            chk =false;
        }
        else chk = true;
        model.addAttribute("chk",chk);
        return "user/loginForm";
    }

    @GetMapping("userInfo")
    public String userInfo(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("userId",principalDetails.getUserId());
        model.addAttribute("username",principalDetails.getUsername());
        model.addAttribute("email",principalDetails.getEmail());
        model.addAttribute("nickname",principalDetails.getNickname());
        return "/user/userInfo";
    }
}
