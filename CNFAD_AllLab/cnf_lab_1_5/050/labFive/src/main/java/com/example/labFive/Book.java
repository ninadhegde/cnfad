package com.example.labFive;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Book {
	@NotNull(message = "Id should not be null")
	@Min(1)
	@Max(100)
	Long id;
	int price;
	@NotBlank(message = "Name should not be blank.")
	String author;
	@NotEmpty(message = "Description should not be empty")
	@Email(message = "This is not in email format")
String descString;
public String getDescString() {
	return descString;
}
public void setDescString(String descString) {
	this.descString = descString;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
}
