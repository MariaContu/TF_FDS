package com.example.sistemaVendas.Aplicacao.model;

public class Relatorio {
    private String conteudo;

    public String getConteudo() {
        return conteudo;
    }

    public void adicionarConteudo(String informacao) {
        conteudo += informacao + "\n";
    }

    @Override
    public String toString() {
        return conteudo;
    }
}
