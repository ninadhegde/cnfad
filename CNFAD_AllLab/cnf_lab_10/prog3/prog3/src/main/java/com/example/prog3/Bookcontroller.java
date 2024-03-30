package com.example.prog3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.annotation.Nonnull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class Bookcontroller {
	private final List<Book> books = new ArrayList<Book>();
	@GetMapping List<Book> getAllBooks() {
		return books;
	}
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return findBookById(id);
	}
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		book.setId(generateBookId());
		books.add(book);
		return book;
	}
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
		Book existingBook = findBookById(id);
		if (existingBook != null) {
			existingBook.setTitle(updatedBook.getTitle());
			existingBook.setAuthor(updatedBook.getAuthor());
			existingBook.setPublicationYear(updatedBook.getPublicationYear());
		}
		return existingBook;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>  deleteBook(@PathVariable Long id) {
		Book bookToRemove = findBookById(id);
		if (bookToRemove != null) {
			books.remove(bookToRemove);
		}
		 return ResponseEntity.status(HttpStatus.OK).body(Map.of(
		            "message", "Book Deleted Successfully"));
	}
	private Book findBookById(Long id) {
		return books.stream()
		.filter(book -> book.getId().equals(id))
		.findFirst()
		.orElse(null);
	}
	private Long generateBookId() {
		return System.currentTimeMillis();
	}
}