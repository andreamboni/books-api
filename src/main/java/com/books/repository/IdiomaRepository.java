package com.books.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Idioma;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long>{
    List<Idioma> findByNome(String nome);
    Optional<Idioma> findByNomeOptional(String nome);
    List<Idioma> findByNomeContaining(String nome);
}
