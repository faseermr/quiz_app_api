package com.online_exam.server.subject;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.online_exam.server.classroom.Classroom;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subid;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "clsid")
    @JsonIgnore
    private Classroom classroom;

    @Column(name = "status")
    private int status;
}
