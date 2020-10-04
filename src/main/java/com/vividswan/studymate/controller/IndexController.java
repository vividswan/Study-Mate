package com.vividswan.studymate.controller;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import com.vividswan.studymate.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        if(principalDetails!=null){
            String username = principalDetails.getUsername();
            Long userId = principalDetails.getUserId();
            model.addAttribute("username",username);
            model.addAttribute("userId",userId);
        }
        return "index";
    }
}
