package rw.ac.rca.smsJunit.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rw.ac.rca.smsJunit.models.Student;
import rw.ac.rca.smsJunit.services.StudentService;

@RestController
public class Students {
	@Autowired
	private StudentService service;
	
	
	

	
	@GetMapping("/get-all-students")
	public List<Student> getAll(){	
		return service.getAllStudents();
	}
	
//	@PostMapping("/add")
//	public void createStudent() {
//		service.createStudent();
//		
//	}
	
	@GetMapping("/getStudent")
	public Student getById(@RequestParam int id) {
		return service.findStudent(id);
	}
	

	@PostMapping("/add")
	public ResponseEntity<?> createStudent() {
		Student stdStudent= service.createStudent();
		return ResponseEntity.status(HttpStatus.CREATED).body(stdStudent);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateStudent(@RequestParam int id) {
		
		Student updStudent=	service.updateStudent(id, new Student(id,"Tracy",13));
		return ResponseEntity.status(HttpStatus.CREATED).body(updStudent);
	}
	
	@DeleteMapping("/remove-student")
	public ResponseEntity<?> removeStd(@RequestParam int id) {
	Student stdStudent= service.RemoveStudent(id);
	return ResponseEntity.ok(stdStudent);
	}
	
}
