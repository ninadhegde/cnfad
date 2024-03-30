package com.example.labSeven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentRepository sRepository;
	
	@GetMapping
	public List<Student> getdata(){
		return sRepository.findAll();
		
	}
	
	@PostMapping
	public void setdata(@RequestBody Student s) {
		sRepository.save(s);
	}
}
