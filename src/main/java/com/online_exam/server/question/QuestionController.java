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

    // add questions to database
    @PostMapping("/question/{subid}")
    public ResponseEntity<Question> addQuestion(@PathVariable("subid") long subid,@RequestBody Question question) {
       Subject subject = subjectRepositary.findById(subid).orElseThrow();
       question.setSubject(subject);
       questionRepositary.save(question);
       return new ResponseEntity<>(question, HttpStatus.OK);
    }

//    @PostMapping("/question")
//    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
//        System.out.println("question : "+question);
//        questionRepositary.save(question);
//        return new ResponseEntity<>(question, HttpStatus.OK);
//    }

    // get all questions
    @GetMapping("/question")
    public ResponseEntity<List<Question>> getAllQuestion(){
        try{
            List<Question> question ;
            question = questionRepositary.findAll();
         //   System.out.println(question);
            return new ResponseEntity<>(question,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get question by subject
    @GetMapping("/question/{subject}")
    public ResponseEntity<List<Question>> getQuestionBySubject(@PathVariable(value="subject") long subject) {
      //  System.out.println("subject : "+((Object)subject).getClass().getSimpleName());
        List<Question> questions = questionRepositary.findBySubjectSubid(subject);
        System.out.println(questions);
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }
}
