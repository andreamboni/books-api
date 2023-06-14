package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Idioma;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long>{
    Idioma findByNome(String nome);
}
