package com.rahul.springbootmongodb.repository;

import java.util.List;

import com.rahul.springbootmongodb.model.Student;

public interface StudentService {

	List<Student> findAll();

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpa();

    void saveOrUpdateStudent(Student student);

    void deleteStudent(String id);
}
