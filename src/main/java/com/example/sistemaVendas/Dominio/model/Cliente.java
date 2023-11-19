package com.example.sistemaVendas.Dominio.model;

import java.util.LinkedList;
import java.util.List;

public class Cliente {

    private long id;

    private String name;
    private List<Orcamento> orcamentos;
    private double valorMedio;
    private int comprasUltimosSeisMeses;
    
    public Cliente(){}

    public Cliente(long id, String name, double valorMedio, int comprasUltimosSeisMeses){
        this.id=id;
        this.name=name;
        orcamentos=new LinkedList<>();
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