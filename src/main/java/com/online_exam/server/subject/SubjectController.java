package com.online_exam.server.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private SubjectRepositary subjectRepositary;

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubject() {
        try {
            List<Subject> subjects = new ArrayList<Subject>();
            subjectRepositary.findAllSubject().forEach(subjects::add);
            System.out.println("subject :"+subjects);
            return new ResponseEntity<>(subjects, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
