package com.online_exam.server.question;

import com.online_exam.server.subject.Subject;
import com.online_exam.server.subject.SubjectRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    SubjectRepositary subjectRepositary;

    @Autowired
    QuestionRepositary questionRepositary;

    @PostMapping("/question/{subid}")
    public ResponseEntity<Question> addQuestion(@PathVariable("subid") long subid,@RequestBody Question question) {
       Subject subject = subjectRepositary.findById(subid).orElseThrow();
       question.setSubject(subject);
       questionRepositary.save(question);
       return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/question")
    public ResponseEntity<List<Question>> getAllQuestion(){
        try{
            List<Question> question = new ArrayList<Question>();
            question = questionRepositary.findAll();
            System.out.println(question);
            return new ResponseEntity<>(question,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
