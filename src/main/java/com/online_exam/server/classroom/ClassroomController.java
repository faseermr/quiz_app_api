package com.online_exam.server.classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ClassroomController {

    @Autowired
    private ClassroomRepositary classroomRepositary;
    @GetMapping("/classrooms")
    List<Classroom> getAllClassroom(){
        return this.classroomRepositary.findAll();
    }

    @PostMapping("/classrooms")
   Classroom addClassroom( @RequestBody Classroom classroom){
    Classroom _classroom = classroomRepositary.save(new Classroom(classroom.getGrade()));
    return _classroom;
   }
    @GetMapping("/classrooms/{id}")
   public ResponseEntity<Classroom> getClassroomById(@PathVariable("id") long id) {
        Classroom _classroom = classroomRepositary.findById(id).orElseThrow();

        return new ResponseEntity<>(_classroom, HttpStatus.OK);

   }
   @PutMapping("classrooms/{id}")
   public ResponseEntity<Classroom> updateTutorial(@PathVariable("id") long id, @RequestBody Classroom classroom){
       Classroom _classroom = classroomRepositary.findById(id).orElseThrow();
       _classroom.setGrade(classroom.getGrade());

       return new ResponseEntity<>(classroomRepositary.save(_classroom),HttpStatus.OK);
   }


   @DeleteMapping("classrooms/{id}")
   public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        classroomRepositary.findById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

   }
}
