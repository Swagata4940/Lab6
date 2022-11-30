package com.gl.StudentManagement.service;

import java.util.List;

import com.gl.StudentManagement.entity.Student;

public interface StudentService {

	List<Student> findAll();

	Student findById(int theId);

	void save(Student theStudent);

	void deleteById(int theId);

}