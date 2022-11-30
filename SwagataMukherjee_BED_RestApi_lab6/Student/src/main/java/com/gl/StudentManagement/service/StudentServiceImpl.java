package com.gl.StudentManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.StudentManagement.entity.Student;
import com.gl.StudentManagement.repository.StudentRepository;

@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public List<Student>findAll(){
		
		List<Student>students=studentRepository.findAll();
		return students;
	}
	
	@Override
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(theId).get();
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentRepository.save(theStudent);
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(theId);
		
	}
}

