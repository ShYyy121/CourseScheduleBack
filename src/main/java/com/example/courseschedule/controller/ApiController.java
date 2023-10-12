package com.example.courseschedule.controller;

import com.example.courseschedule.domain.MyUserDetail;
import com.example.courseschedule.domain.Role;
import com.example.courseschedule.dto.CollisionResult;
import com.example.courseschedule.service.PreScheduleService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final PreScheduleService preScheduleService;

    public ApiController(PreScheduleService preScheduleService) {
        this.preScheduleService = preScheduleService;
    }

    @GetMapping("/api/flush")
    public CollisionResult flushToSchedule() {
        return preScheduleService.flushToSchedule();
    }

    @GetMapping("/api/user")
    public MyUserDetail dispatcher(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetail myUserDetail = (MyUserDetail)authentication.getPrincipal();
        System.out.println(myUserDetail);
        // 进一步操作或获取用户的详细信息
        // ...
        return myUserDetail;
    }
}
