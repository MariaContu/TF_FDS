package com.example.sistemaVendas.Dominio.model;

import java.util.List;

import javax.persistence.Entity;



@Entity
public class Cliente {

    private long id;

    private List<Orcamento> orcamentos;
    private String name;
    private double valorMedio;
    private int comprasUltimosSeisMeses;

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

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
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

    public void setOrcamentos(List<Orcamento> orcamentos)    {
        this.orcamentos=orcamentos;
    }
}