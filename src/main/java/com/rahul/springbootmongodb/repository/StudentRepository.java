package com.rahul.springbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rahul.springbootmongodb.model.Student;

public interface StudentRepository extends MongoRepository<Student, String>{

	Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpa();
}
