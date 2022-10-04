package com.online_exam.server.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClassroomController {

    @Autowired
    private ClassroomRepositary classroomRepositary;
    @GetMapping("/classroom")
    List<Classroom> getAllClassroom(){
        return this.classroomRepositary.findAll();
    }
}
