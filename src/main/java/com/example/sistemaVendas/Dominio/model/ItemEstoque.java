package com.example.sistemaVendas.Dominio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private long codigoProduto;
    private int quantMax;
    private int quantMin;
    private int quantAtual;

    public ItemEstoque(long codProd, int qntMax, int qntMin, int qntAtual){
        codigoProduto = codProd;
        quantMax = qntMax;
        quantMin = qntMin;
        quantAtual = qntAtual;
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

    public void setQuantAtual(int quantPedida) {
        if (this.quantAtual-quantPedida>quantMin && quantPedida<=this.quantAtual) {
            this.quantAtual = this.quantAtual-quantPedida;
        }
        else System.out.print("Quantidade inválida!");
    }

}
