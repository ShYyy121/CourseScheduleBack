//package com.example.courseschedule.controller;
//
//import com.example.courseschedule.dao.ClassroomDao;
//import com.example.courseschedule.domain.Classroom;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/classrooms")
//public class ClassroomController {
//
//    private final ClassroomDao classroomDao;
//
//    @Autowired
//    public ClassroomController(ClassroomDao classroomDao) {
//        this.classroomDao = classroomDao;
//    }
//
//    @GetMapping("/")
//    public List<Classroom> getAllClassrooms() {
//        return classroomDao.findAll();
//    }
//
//    @GetMapping("/{classroomId}")
//    public Classroom getClassroomById(@PathVariable int classroomId) {
//        return classroomDao.findById(classroomId)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid classroom ID: " + classroomId));
//    }
//
//    @PostMapping("/")
//    public Classroom createClassroom(@RequestBody Classroom classroom) {
//        return classroomDao.save(classroom);
//    }
//
//    @PutMapping("/{classroomId}")
//    public Classroom updateClassroom(@PathVariable int classroomId, @RequestBody Classroom updatedClassroom) {
//        return classroomDao.findById(classroomId)
//                .map(classroom -> {
//                    classroom.setClassroomName(updatedClassroom.getClassroomName());
//                    classroom.setEquipmentType(updatedClassroom.getEquipmentType());
//                    classroom.setEquipmentCount(updatedClassroom.getEquipmentCount());
//                    classroom.setCapacity(updatedClassroom.getCapacity());
//                    // 设置其他属性
//                    return classroomDao.save(classroom);
//                })
//                .orElseThrow(() -> new IllegalArgumentException("Invalid classroom ID: " + classroomId));
//    }
//
//    @DeleteMapping("/{classroomId}")
//    public void deleteClassroom(@PathVariable int classroomId) {
//        classroomDao.deleteById(classroomId);
//    }
//}
