package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String nome);
}
