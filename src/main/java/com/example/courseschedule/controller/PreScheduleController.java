package com.example.courseschedule.controller;

import com.example.courseschedule.dao.PreScheduleDao;
import com.example.courseschedule.domain.Classroom;
import com.example.courseschedule.domain.PreSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/preschedules")
public class PreScheduleController {

    private final PreScheduleDao preScheduleDao;

    @Autowired
    public PreScheduleController(PreScheduleDao preScheduleDao) {
        this.preScheduleDao = preScheduleDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreSchedule> getPreScheduleById(@PathVariable("id") String id) {
        Optional<PreSchedule> preSchedule = preScheduleDao.findById(id);
        return preSchedule.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PreSchedule> createPreSchedule(@RequestBody PreSchedule preSchedule) {
        System.out.println(preSchedule.toString());
        int classroomId = preSchedule.getClassroom().getClassroomId();
        PreSchedule createdPreSchedule = preScheduleDao.save(preSchedule);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPreSchedule);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<PreSchedule> updatePreSchedule(@PathVariable("id") String id, @RequestBody PreSchedule preSchedule) {
//        if (!preScheduleDao.existsById(id)) {
//            return ResponseEntity.notFound().build();
//        }
//        preSchedule.setId(id);
//        PreSchedule updatedPreSchedule = preScheduleDao.save(preSchedule);
//        return ResponseEntity.ok(updatedPreSchedule);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreSchedule(@PathVariable("id") String id) {
        if (!preScheduleDao.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        preScheduleDao.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
