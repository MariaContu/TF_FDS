package com.example.sistemaVendas.Dominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
