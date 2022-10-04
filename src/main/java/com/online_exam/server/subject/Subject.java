package com.online_exam.server.subject;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.online_exam.server.classroom.Classroom;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
@CrossOrigin
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subid;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "clsid",referencedColumnName = "clsid",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Classroom classroom;

    @Column(name = "status")
    private int status;


    public Subject() {
    }

    public Subject(String name, Classroom classroom, int status) {
        this.name = name;
        this.classroom = classroom;
        this.status = status;
    }

    public Long getSubid() {
        return subid;
    }

    public void setSubid(Long subid) {
        this.subid = subid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subid=" + subid +
                ", name='" + name + '\'' +
                ", classroom=" + classroom +
                ", status=" + status +
                '}';
    }
}
