package com.example.labThree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class MyRestController {
	final List<Book> books=new ArrayList<>(); 
	
	@GetMapping
	List<Book> getdata() {
		return books;
	}
	
	@PostMapping
	void setdata(@RequestBody Book newdata) {
		books.add(newdata);
	}
	
}
