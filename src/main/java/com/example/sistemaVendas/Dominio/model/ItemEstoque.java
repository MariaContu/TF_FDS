package com.example.sistemaVendas.Dominio.model;

public class ItemEstoque {

    private int id;
    
    private long codigoProduto;
    private int quantMax;
    private int quantMin;
    private int quantAtual;

    public ItemEstoque(){}

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

    public void setQuantAtual(int quantPedida) {
        if (this.quantAtual-quantPedida>quantMin && quantPedida<=this.quantAtual) {
            this.quantAtual = this.quantAtual-quantPedida;
        }
        else System.out.print("Quantidade inválida!");
    }

}
