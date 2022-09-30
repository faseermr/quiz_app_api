package com.online_exam.server.submit_student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.online_exam.server.student.Student;
import com.online_exam.server.subject.Subject;

import javax.persistence.*;

@Entity
@Table(name = "submit_student")
public class Submit_Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "stuid")
    @JsonIgnore
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "subid")
    @JsonIgnore
    private Subject subject;

    public Submit_Student() {
    }

    public Submit_Student(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Submit_Student{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
