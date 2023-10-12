package com.example.courseschedule.controller;

import com.example.courseschedule.domain.MyUserDetail;
import com.example.courseschedule.domain.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/redirect")
    public String dispatcher(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetail myUserDetail = (MyUserDetail)authentication.getPrincipal();
        System.out.println(myUserDetail);
        // 进一步操作或获取用户的详细信息
        // ...

        if (myUserDetail.getRole() == Role.ADMIN){
            return "redirect:http://localhost:3000/Navbar/userinfo";
        }else if (myUserDetail.getRole()== Role.TEACHER) {
            return "redirect:http://localhost:3000/teacher";
        }
        return "Current User: " + myUserDetail.getName();
    }

}
