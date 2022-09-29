package com.online_exam.server.classroom;
import javax.persistence.*;

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clsid;

    public Classroom() {
    }

    public Classroom(String grade) {
        this.grade = grade;
    }

    @Column(name = "grade")
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
