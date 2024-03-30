package com.example.labFive;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


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
	ResponseEntity<?> setdata(@Valid @RequestBody Book newdata, BindingResult result) {
			if(result.hasErrors()) {
				List<String> errors = new ArrayList<String>();
				result.getFieldErrors().forEach(error -> errors.add(error.getField()+":"+error.getDefaultMessage()));
				return ResponseEntity.badRequest().body(errors);
			}
			else{books.add(newdata);
			return ResponseEntity.status(HttpStatus.CREATED).body(newdata);
		}	}
	
	@PutMapping("/{id}")
	ResponseEntity<?> updatedata(@PathVariable int id, @Valid @RequestBody Book newdata, BindingResult result) {
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getFieldErrors().forEach(error -> errors.add(error.getField()+":"+error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(errors);
		}
		else{
			Book b =  getbookbyid(id);
			b.setAuthor(newdata.getAuthor());
			b.setPrice(newdata.getPrice());
		return ResponseEntity.status(HttpStatus.CREATED).body(books);
	}	}

	
	
	
	

	Book getbookbyid(int id) {
		for(Book b:books) {
			if(b.getId()==id) {
				return b;
			}
		}
		return books.get(0);
	}
}










