package com.books.model.request;

import java.util.List;

import com.books.model.enums.Acabamento;
import com.books.model.enums.Formato;
import com.books.model.enums.Tipo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroRequest {
    private String colecao;
    private String titulo;
    private String autor;
    private String editora;
    private Tipo tipo;
    private Formato formato;
    private Integer quantidadePaginas;
    private Integer edicao;
    private Integer anoEdicao;
    private List<String> generos;
    private Acabamento acabamento;
    private String idioma;
    private String pais;
    private Integer quantidadeLivros;
}
