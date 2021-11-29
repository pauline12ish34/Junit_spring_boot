package rw.ac.rca.smsJunit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWord {
	@GetMapping("/hello-world")
	public String hello() {
		return "hello world you pauline";
	
}}
