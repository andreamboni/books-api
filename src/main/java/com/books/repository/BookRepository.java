package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.model.Livro;

public interface BookRepository extends JpaRepository<Livro, Long> {
    
}
