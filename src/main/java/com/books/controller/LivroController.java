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

import com.books.model.Autor;
import com.books.model.Idioma;
import com.books.model.Livro;
import com.books.model.Pais;
import com.books.repository.AutorRepository;
import com.books.repository.GeneroRepository;
import com.books.repository.IdiomaRepository;
import com.books.repository.LivroRepository;
import com.books.repository.PaisRepository;
import com.books.request.LivroRequest;

@RestController
@RequestMapping(path = "livros")
@CrossOrigin
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private IdiomaRepository idiomaRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private GeneroRepository generoRepository;

	@GetMapping(value = "getLivros")
	public List<Livro> getAllMyBooks() {
		return livroRepository.findAll();
	}

	@PostMapping(value = "addLivro")
	public ResponseEntity<?> addBook(@RequestBody LivroRequest request) {
		Autor autor = autorRepository.findByNome(request.getAutor());
		Idioma idioma = idiomaRepository.findByNome(request.getIdioma());
		Pais pais = paisRepository.findByNome(request.getPais());

		for(String genero : request.getGeneros()) {

			if (generoRepository.findByNome(genero) == null) {
				return ResponseEntity.badRequest().body("O genero " + genero + " não existe");
			}

		}

		if (autor == null) {
			return ResponseEntity.badRequest().body("O autor não existe");
		}

		if (idioma == null) {
			return ResponseEntity.badRequest().body("O idioma não existe");
		}

		if (pais == null) {
			return ResponseEntity.badRequest().body("O pais não existe");
		}

		return ResponseEntity.ok(livroRepository.save(new Livro(request, autor, idioma, pais)));
	}

}
