package com.example.studentproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "province")
@Getter
@Setter
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "province", cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        student.setProvince(this);
        students.add(student);
    }
}
