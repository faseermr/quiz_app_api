package com.online_exam.server.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositary extends JpaRepository<Student,Long> {

    Student findByName(String name);
}
