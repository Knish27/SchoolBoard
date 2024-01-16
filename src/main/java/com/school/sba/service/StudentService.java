package com.school.sba.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.school.sba.entity.Student;
import com.school.sba.util.ResponseStructure;

public interface StudentService {
	public ResponseEntity<ResponseStructure<Student>> addStudent(Student student);
	public ResponseEntity<ResponseStructure<Student>> findStudent(int studId);
	public ResponseEntity<ResponseStructure<Student>> updateStudent(int studentId, Student updatedStudent);
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int studentId);
	public ResponseEntity<ResponseStructure<List<Student>>> findAll();
}
