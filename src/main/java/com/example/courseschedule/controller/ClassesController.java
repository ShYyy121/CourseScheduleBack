package com.example.courseschedule.controller;

import com.example.courseschedule.dao.ClassDao;
import com.example.courseschedule.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.courseschedule.domain.Class;
import java.util.List;


@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    private final ClassDao classDao;

@Autowired
    public ClassesController(ClassDao classDao) {
        this.classDao = classDao;
    }

    @GetMapping("/search/findByTeacher")
    public List<Class> getClassesByTeacher(@RequestParam("id") int id) {
    Teacher teacher=new Teacher();
    teacher.setTeacherId(id);
    return classDao.findByTeacher(teacher);
    }
}
