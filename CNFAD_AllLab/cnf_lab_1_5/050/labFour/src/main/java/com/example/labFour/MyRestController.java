package com.example.labFour;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("{id}")
	Book getdata(@PathVariable int id) {
		return  getbookbyid(id);
	}
	
	@PostMapping
	void setdata(@RequestBody Book newdata) {
		
		books.add(newdata);
	}
	
	@PutMapping("/{id}")
	void updatedata(@PathVariable int id,@RequestBody Book newdata) {
		Book b =  getbookbyid(id);
		b.setAuthor(newdata.getAuthor());
		b.setPrice(newdata.getPrice());
	}
	
	@DeleteMapping("/{id}")
	void deletedata(@PathVariable int id) {
	 	Book b= getbookbyid(id);
	 	books.remove(b);
	}
	
	Book getbookbyid(int id) {
		for(Book b:books) {
			if(b.getId()==id) {
				return b;
			}
		}
		return books.get(0);
	}
}
