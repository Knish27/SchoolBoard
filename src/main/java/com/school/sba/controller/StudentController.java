package com.school.sba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.entity.Student;
import com.school.sba.service.StudentService;
import com.school.sba.util.ResponseStructure;
@RestController
@RequestMapping("/students")
public class StudentController {


	@Autowired
	private StudentService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	@GetMapping("/{studId}")
	public ResponseEntity<ResponseStructure<Student>> findStudent(@PathVariable int studId) {
		return service.findStudent(studId);
	}
	@PutMapping("/{studId}")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@PathVariable int studId, @RequestBody Student student) {
		return service.updateStudent(studId, student);
	}
	@DeleteMapping("/{studId}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int studId) {
		return service.deleteStudent(studId);
	}
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Student>>> findAll() {
		return service.findAll();
	}
}

