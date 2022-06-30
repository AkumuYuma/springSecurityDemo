package com.springSecurityDemo.securityDemo.students;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	private static final List<Student> STUDENTS = Arrays.asList(
			new Student(1, "Marco"), 
			new Student(2, "Antonio"),
			new Student(3, "Ciccio")
		); 
	
	@GetMapping(path = "{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return STUDENTS.stream()
				.filter((student) -> studentId.equals(student.getStudentId()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No student with id: " + studentId)); 
	}
}
