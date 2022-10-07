package com.online_exam.server.question;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepositary extends JpaRepository<Question,Long> {
}
