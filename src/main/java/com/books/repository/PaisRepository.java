package com.books.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository <Pais, Long> {
    Optional<Pais> findByNome(String nome);
}
