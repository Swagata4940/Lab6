package com.gl.StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.StudentManagement.entity.Student;
import com.gl.StudentManagement.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	
	
	@RequestMapping("/list")
	public String listStudents(Model theModel) {
		
		List<Student>theStudent=studentService.findAll();
		
		theModel.addAttribute("Students", theStudent);
		
		return "list-Students";
	
	}
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
			Model theModel) {

		// get the Book from the service
		Student theStudent = studentService.findById(theId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "Student-form";			
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("id")int id, @RequestParam("firstName")String firstName,
			@RequestParam("lastName")String lastName,@RequestParam("course")String course,@RequestParam("country")String country) {
		
		System.out.println(id);
		Student theStudent;
		if (id !=0) {
			theStudent = studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
			}
		else
			theStudent = new Student(firstName,lastName,course,country);
		
		studentService.save(theStudent);
		
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		
		studentService.deleteById(theId);

		return "redirect:/students/list";

	}
}

