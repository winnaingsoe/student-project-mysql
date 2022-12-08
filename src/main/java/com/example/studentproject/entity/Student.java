package com.example.studentproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    private String name;
    private String school;
    private int age;
    @JoinColumn(name = "p_id")
    @ManyToOne
    private Province province;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private List<StudentSubject> studentSubjects = new ArrayList<>();

    public Student() {

    }

    public Student(String name, String school, int age) {
        this.name = name;
        this.school = school;
        this.age = age;
    }

    public void addStudentSubject(StudentSubject studentSubject) {
        studentSubject.setStudent(this);
        studentSubjects.add(studentSubject);
    }
}
