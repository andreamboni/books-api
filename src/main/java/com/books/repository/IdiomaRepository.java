package com.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Idioma;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long>{
    Optional<Idioma> findByNome(String nome);
}
