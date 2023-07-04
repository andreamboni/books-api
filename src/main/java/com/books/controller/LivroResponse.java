package com.books.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.books.model.Livro;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Component
@JsonInclude(Include.NON_EMPTY)
@Getter
public class LivroResponse {
    private Map<String, String> mensagensErro = new HashMap<String, String>();
    private Map<String, String> mensagensAviso = new HashMap<String, String>();
    private @Setter Livro livro;

    public void addMensagemErro(String erro, String mensagemErro) {
        this.mensagensErro.put(erro, mensagemErro);
    }

    public void addMensagemAviso(String aviso, String mensagemAviso) {
        this.mensagensAviso.put(aviso, mensagemAviso);
    }
}
