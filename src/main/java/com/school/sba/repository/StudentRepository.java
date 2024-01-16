package com.school.sba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.sba.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
