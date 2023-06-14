package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
