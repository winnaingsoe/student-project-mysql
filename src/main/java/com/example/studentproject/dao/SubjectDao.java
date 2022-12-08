package com.example.studentproject.dao;

import com.example.studentproject.entity.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectDao extends CrudRepository<Subject, Integer> {
}
