package com.online_exam.server.subject;

import com.online_exam.server.classroom.Classroom;
import com.online_exam.server.classroom.ClassroomRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class SubjectController {

    @Autowired
    private SubjectRepositary subjectRepositary;

    @Autowired
    private ClassroomRepositary classroomRepositary;

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubject() {
        try {
            List<Subject> subjects = new ArrayList<Subject>();
            subjects = subjectRepositary.findAllSubject();

            //subjectRepositary.findAllSubject().forEach(subjects::add);
            System.out.println("subject :"+subjects);
            return new ResponseEntity<>(subjects, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getAllSubjectById(@PathVariable("id") long id) {
        Subject _subject = subjectRepositary.findById(id).orElseThrow();
        return new ResponseEntity<>(_subject,HttpStatus.OK);
    }

    @PostMapping("/subjects/{clsid}")
    public ResponseEntity<Subject> addSubject(@PathVariable("clsid") long clsid, @RequestBody Subject subject){
        Classroom classroom = classroomRepositary.findById(clsid).orElseThrow();
        subject.setClassroom(classroom);
        subjectRepositary.save(subject);
       return new ResponseEntity<>(subject,HttpStatus.CREATED);

    }

    @DeleteMapping("subjects/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        subjectRepositary.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
