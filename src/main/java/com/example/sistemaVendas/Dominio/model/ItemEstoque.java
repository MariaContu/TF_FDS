package com.example.sistemaVendas.Dominio.model;

public class ItemEstoque {

    private int id;
    private long codigoProduto;
    private int quantMax;
    private int quantMin;
    private int quantAtual;

    public ItemEstoque(){}

    public ItemEstoque(int id, long codigoProduto, int quantMax, int quantMin, int quantAtual){
        this.id=id;
        this.codigoProduto=codigoProduto;
        this.quantMax=quantMax;
        this.quantMin=quantMin;
        this.quantAtual=quantAtual;
    }

    public int getId() {
        return id;
    }

    public long getCodigoProduto() {
        return codigoProduto;
    }

    public int getQuantMin() {
        return quantMin;
    }

    public int getQuantMax() {
        return quantMax;
    }

    public int getQuantAtual() {
        return quantAtual;
    }

    public void setQuantAtual(int quantAtual) {
        this.quantAtual=quantAtual;
    }
}