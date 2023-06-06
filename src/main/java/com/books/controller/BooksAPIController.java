package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Livro;
import com.books.repository.BookRepository;
import com.books.service.BookService;

@RestController
@RequestMapping
@CrossOrigin
public class BooksAPIController {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Livro> getAllMyBooks() {
		return bookRepository.findAll();
	}
	
	@PostMapping(value="addBook")
	public ResponseEntity<?> addBook(@RequestBody Livro book) {
		return bookService.addNewBook(book);
	}

}
