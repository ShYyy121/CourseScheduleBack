package com.example.courseschedule.service;

import com.example.courseschedule.dao.AdministratorDao;
import com.example.courseschedule.dao.TeacherDao;
import com.example.courseschedule.domain.Administrator;
import com.example.courseschedule.domain.MyUserDetail;
import com.example.courseschedule.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final AdministratorDao administratorDao;
    private final TeacherDao teacherDao;

    public UserDetailServiceImpl(@Autowired AdministratorDao administratorDao, @Autowired TeacherDao teacherDao) {
        this.administratorDao = administratorDao;
        this.teacherDao = teacherDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername: " + username);
        Teacher teacher = teacherDao.findByTeacherName(username);
        if (teacher != null) {
            return new MyUserDetail(teacher);
        }
        Administrator administrator = administratorDao.findByAdminName(username);
        if (administrator != null) {
            return new MyUserDetail(administrator);
        }
        System.out.println("用户名不存在或用户类型错误");
        throw new UsernameNotFoundException("用户名不存在或用户类型错误");
    }
}
