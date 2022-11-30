package com.gl.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.StudentManagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}