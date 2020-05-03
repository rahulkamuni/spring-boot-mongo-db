package com.rahul.springbootmongodb;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.rahul.springbootmongodb.model.Student;
import com.rahul.springbootmongodb.repository.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/")
	public List<Student> getAllStudents() {
		return studentService.findAll();
	}

	@GetMapping(value = "/{studentNumber}")
	public Student getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
		return studentService.findByStudentNumber(studentNumber);
	}

	@GetMapping(value = "/{email}")
	public Student getStudentByEmail(@PathVariable("email") String email) {
		return studentService.findByEmail(email);
	}

	@PostMapping(value = "/")
	public ResponseEntity<?> saveOrUpdateStudent(@RequestBody Student student) {
		studentService.saveOrUpdateStudent(student);
		return new ResponseEntity("Student added successfully", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{studentNumber}")
	public void deleteStudent(@PathVariable Long studentNumber) {
		studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
	}

}
