package com.example.sistemaVendas.Aplicacao.model;

import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    private List<String> secoes;

    public Relatorio() {
        this.secoes = new ArrayList<>();
    }

    public void adicionarSecao(String secao) {
        secoes.add(secao);
    }

    public void adicionarConteudo(List<String> conteudo) {
        this.secoes.addAll(conteudo);
    }

    public List<String> getSecoes() {
        return secoes;
    }

    @Override
    public String toString() {
        return String.join("\n", secoes);
    }
}