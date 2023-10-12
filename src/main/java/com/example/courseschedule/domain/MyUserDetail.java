package com.example.courseschedule.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class MyUserDetail implements UserDetails, Serializable {
    private Administrator administrator;
    private Teacher teacher;

    private final Role role;

    public MyUserDetail(Administrator administrator) {
        this.administrator = administrator;
        role = Role.ADMIN;
    }

    public MyUserDetail(Teacher teacher) {
        this.teacher = teacher;
        role = Role.TEACHER;
    }

    public Role getRole() {
        return role;
    }

    public int getId() {
        if (role == Role.ADMIN) {
            return administrator.getAdminId();
        } else {
            return teacher.getTeacherId();
        }
    }

    public String getName() {
        if (role == Role.ADMIN) {
            return administrator.getAdminName();
        } else {
            return teacher.getTeacherName();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == Role.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }else {
            return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"));
        }

    }

    @Override
    public String getPassword() {
        if (role == Role.ADMIN) {
            return administrator.getAdminPassword();
        } else {
            return teacher.getTeacherPassword();
        }
    }

    @Override
    public String getUsername() {
        if (role == Role.ADMIN) {
            return administrator.getAdminName();
        } else {
            return teacher.getTeacherName();
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
