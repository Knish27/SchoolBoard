package com.school.sba.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.sba.entity.Student;
import com.school.sba.exception.SchoolNotFoundByIdException;
import com.school.sba.repository.StudentRepository;
import com.school.sba.service.StudentService;
import com.school.sba.util.ResponseStructure;
@Service
public class StudentServiceImpl implements StudentService {

		@Autowired
		private StudentRepository studentRepository;
		@Override
		public ResponseEntity<ResponseStructure<Student>> addStudent(Student student) {
			Student stud = studentRepository.save(student);

			ResponseStructure<Student> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Student Object Created Successfully");
			responseStructure.setData(stud);

			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.CREATED);
		}
		@Override
		public ResponseEntity<ResponseStructure<Student>> findStudent(int studId) {
			Optional<Student> optional = studentRepository.findById(studId);
			if(optional.isPresent()) {
				Student stud=optional.get();
				ResponseStructure<Student> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("Student Object Found Successfully");
				responseStructure.setData(stud);

				return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);

			}else {
				throw new SchoolNotFoundByIdException("School Not Found!!!");
			}
		}
		@Override
		public ResponseEntity<ResponseStructure<Student>> updateStudent(int studId, Student updatedStudent) {
			Optional<Student> optional = studentRepository.findById(studId);

			if(optional.isPresent()) {
				Student existinStudent = optional.get();
				updatedStudent.setStudId(existinStudent.getStudId());
				Student std = studentRepository.save(updatedStudent);

				ResponseStructure<Student> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("School Object Updated Successfully");
				responseStructure.setData(std);

				return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);	
			}else {
				throw new SchoolNotFoundByIdException("School Not Found!!!");
			}
		}
		@Override
		public ResponseEntity<ResponseStructure<Student>> deleteStudent(int studId) {
			Optional<Student> optional = studentRepository.findById(studId);

			if(optional.isPresent()) {
				Student stud= optional.get();
				studentRepository.delete(stud);

				ResponseStructure<Student> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setMessage("School Object deleted Successfully");
				responseStructure.setData(stud);

				return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
			}else {
				throw new SchoolNotFoundByIdException("School Not Found!!!");
			}
		}

		public ResponseEntity<ResponseStructure<List<Student>>> findAll(){
			List<Student> sl = studentRepository.findAll();

			if(sl.isEmpty()) {
				return null;

			}else {


				ResponseStructure<List<Student>> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.FOUND.value());
				responseStructure.setMessage("School Objects Found Successfully");
				responseStructure.setData(sl);

				return new ResponseEntity<ResponseStructure<List<Student>>>(responseStructure,HttpStatus.FOUND);

			}
		}
	
}
