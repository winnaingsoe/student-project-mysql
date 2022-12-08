package com.example.studentproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer id;
    private String name;
    private String duration;
    private int price;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.PERSIST)
    private List<StudentSubject> studentSubjects = new ArrayList<>();

    public Subject() {

    }

    public Subject(String name, String duration, int price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public void addStudentSubject(StudentSubject studentSubject) {
        studentSubject.setSubject(this);
        studentSubjects.add(studentSubject);
    }
}
