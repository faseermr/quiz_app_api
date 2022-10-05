package com.online_exam.server.classroom;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "classroom")
public class Classroom {

    public Classroom() {
    }

    public Classroom(String grade) {
        this.grade = grade;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clsid;
    @Column(name = "grade")
    @NotEmpty
    private String grade;



    public Long getClsid() {
        return clsid;
    }

    public void setClsid(Long clsid) {
        this.clsid = clsid;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "clsid=" + clsid +
                ", grade='" + grade + '\'' +
                '}';
    }
}
