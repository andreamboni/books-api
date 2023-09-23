package com.books.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Idioma;

@Repository
public interface IdiomaRepository extends JpaRepository<Idioma, Long>{
    List<Idioma> findByNome(String nome);
    List<Idioma> findByNomeContaining(String nome);
}
