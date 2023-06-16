package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Genero findByNome(String nome);
}
