package com.example.labSeven;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService { 
	@Autowired
	private StudentRepository sRepository;
	public void insert(String name,int marks) {
		Student student=new Student();
		student.setMarks(marks);
		student.setName(name);
		sRepository.save(student);
	}
	public List<Student> display() {
		return sRepository.findAll();
	}
	public void delete(int id){
		sRepository.deleteById(id);
	}
	
	public void update(int id,int marks) {
		Student student =sRepository.findById(id).orElse(null);
		student.setMarks(marks);
		sRepository.save(student);
	}
}
