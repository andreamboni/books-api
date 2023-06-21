package com.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.model.Colecao;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao, Long> {
    Colecao findByNome(String nome);
}
