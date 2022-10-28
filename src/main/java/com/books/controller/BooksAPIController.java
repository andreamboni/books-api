package com.books.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.MyBook;

@RestController
@RequestMapping
@CrossOrigin
public class BooksAPIController {

	@GetMapping
	public Set<MyBook> getAllMyBooks() {
		return null;
	}
	
}
