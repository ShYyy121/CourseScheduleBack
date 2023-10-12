//package com.example.courseschedule.controller;
//
//import com.example.courseschedule.dao.ClassDao;
//import com.example.courseschedule.domain.Class;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/classes")
//public class ClassController {
//
//    private final ClassDao classDao;
//
//    @Autowired
//    public ClassController(ClassDao classDao) {
//        this.classDao = classDao;
//    }
//
//    @GetMapping("/")
//    public List<Class> getAllClasses() {
//        return (List<Class>) classDao.findAll();
//    }
//
//    @GetMapping("/{classId}")
//    public Class getClassById(@PathVariable String classId) {
//        return classDao.findById(classId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid class ID: " + classId));
//    }
//
//    @PostMapping("/")
//    public Class createClass(@RequestBody Class classObj) {
//        return classDao.save(classObj);
//    }
//
//
//
//    @DeleteMapping("/{classId}")
//    public void deleteClass(@PathVariable String classId) {
//        classDao.deleteById(classId);
//    }
//}
