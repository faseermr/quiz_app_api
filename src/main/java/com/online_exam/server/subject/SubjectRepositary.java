package com.online_exam.server.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepositary extends JpaRepository<Subject,Long> {
    @Query(value = "SELECT * FROM subject ",nativeQuery = true)
    List<Subject> findAllSubject();
}
