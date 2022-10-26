package com.online_exam.server.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepositary extends JpaRepository<Question,Long> {

   //@Query(value = "Select * From question q where q.subid=?",nativeQuery = true)
  // List<Question> findBySubject(long subid);

     List<Question> findBySubjectSubid(long subid);
}
