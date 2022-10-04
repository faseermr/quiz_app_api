package com.online_exam.server.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.online_exam.server.question.Question;
import com.online_exam.server.student.Student;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ansid;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "qid")
    @JsonIgnore
    private Question qusetion;

    @Column(name = "ans")
    private String ans;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "stuid")
    private Student student;


    public Answer() {
    }

    public Answer(Question qusetion, String ans, Student student) {
        this.qusetion = qusetion;
        this.ans = ans;
        this.student = student;
    }

    public Long getAnsid() {
        return ansid;
    }

    public void setAnsid(Long ansid) {
        this.ansid = ansid;
    }

    public Question getQusetion() {
        return qusetion;
    }

    public void setQusetion(Question qusetion) {
        this.qusetion = qusetion;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "ansid=" + ansid +
                ", qusetion=" + qusetion +
                ", ans='" + ans + '\'' +
                ", student=" + student +
                '}';
    }
}
