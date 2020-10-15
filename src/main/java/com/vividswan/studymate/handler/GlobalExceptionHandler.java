package com.vividswan.studymate.handler;

import com.vividswan.studymate.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        model.addAttribute("username",principalDetails.getUsername());
        model.addAttribute("errorMessage",e.getMessage());
        return "errorView";
    }
}
