package com.online_exam.server.student;

import com.online_exam.server.classroom.Classroom;
import com.online_exam.server.classroom.ClassroomRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepositary studentRepositary;

    @Autowired
    ClassroomRepositary classroomRepositary;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/student/{clsid}")
    public ResponseEntity<Student> addStudent(@PathVariable("clsid") long clsid, @RequestBody Student student) {
        Classroom classroom = classroomRepositary.findById(clsid).orElseThrow();
        student.setClassroom(classroom);
        System.out.println("student :"+ student);
        String encrptPwd = passwordEncoder.encode(student.getPassword());
        student.setPassword(encrptPwd);
        studentRepositary.save(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> student = studentRepositary.findAll();
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
}
