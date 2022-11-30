package com.gl.StudentManagement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data

@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="FirstName")
	private String FirstName;
	
	@Column(name="LastName")
	private String LastName;
	
	@Column(name="Course")
	private String Course;
	
	@Column(name="Country")
	private String Country;

	public Student(String firstName, String lastName, String course, String country) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Course = course;
		Country = country;
	}

	public Student() {
		
	}

	
	
	
}
