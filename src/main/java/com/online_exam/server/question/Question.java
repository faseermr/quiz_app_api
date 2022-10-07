package com.online_exam.server.question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.online_exam.server.subject.Subject;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qid;

    @Column(name = "qfield")
    private String qfield;

    @Column(name = "ans1")
    private  String ans1;

    @Column(name = "ans2")
    private  String ans2;

    @Column(name = "ans3")
    private  String ans3;

    @Column(name = "ans4")
    private  String ans4;

    @Column(name = "correct_ans")
    private  String correct_ans;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "subid")
    private Subject subject;

    public Question() {
    }

    public Question(String qfield, String ans1, String ans2, String ans3, String ans4, String correct_ans, Subject subject) {
        this.qfield = qfield;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
        this.correct_ans = correct_ans;
        this.subject = subject;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getQfield() {
        return qfield;
    }

    public void setQfield(String qfield) {
        this.qfield = qfield;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAns4() {
        return ans4;
    }

    public void setAns4(String ans4) {
        this.ans4 = ans4;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Question{" +
                "qid=" + qid +
                ", qfield='" + qfield + '\'' +
                ", ans1='" + ans1 + '\'' +
                ", ans2='" + ans2 + '\'' +
                ", ans3='" + ans3 + '\'' +
                ", ans4='" + ans4 + '\'' +
                ", correct_ans='" + correct_ans + '\'' +
                ", subject=" + subject +
                '}';
    }
}
