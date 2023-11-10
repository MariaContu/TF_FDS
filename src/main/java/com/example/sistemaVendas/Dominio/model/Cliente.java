package com.example.sistemaVendas.Dominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double valorMedio;
    private int comprasUltimosSeisMeses;
    
    public Cliente(){}

    public Cliente(long id, String name, double valorMedio, int comprasUltimosSeisMeses){
        this.id=id;
        this.name=name;
        this.valorMedio=valorMedio;
        this.comprasUltimosSeisMeses=comprasUltimosSeisMeses;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getValorMedio() {
        return valorMedio;
    }

    public int getComprasUltimosSeisMeses() {
        return comprasUltimosSeisMeses;
    }

    public void setValorMedio(double valorMedio) {
        this.valorMedio = valorMedio;
    }

    public void setComprasUltimosSeisMeses(int comprasUltimosSeisMeses) {
        this.comprasUltimosSeisMeses = comprasUltimosSeisMeses;
    }
}