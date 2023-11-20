package com.example.sistemaVendas.Aplicacao.model;

public class Relatorio {
    private String conteudo;
    private double custoTotalMedio;
    private double custoMedioFinal;
    private int mediaItensPorPedido;

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

    public double getCustoTotalMedio() {
        return custoTotalMedio;
    }

    public double getCustoMedioFinal() {
        return custoMedioFinal;
    }

    public int getMediaItensPorPedido() {
        return mediaItensPorPedido;
    }

    public void setAverageItensPerOrder(int mediaItensPorPedido) {
        this.mediaItensPorPedido = mediaItensPorPedido;
    }

    public void setAverageTotalCost(double custoTotalMedio) {
        this.custoTotalMedio = custoTotalMedio;
    }

    public void setAverageFinalCost(double custoMedioFinal) {
        this.custoMedioFinal = custoMedioFinal;
    }
}
