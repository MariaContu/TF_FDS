package com.example.sistemaVendas.Dominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String descricao;
    private double precoUnit;

    public Produto() {
    }

    public Produto(long codigo, String descricao, double precoUnit) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.precoUnit = precoUnit;
    }

    public long getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    @Override
    public String toString() {
        return "Produto [codigo = " + codigo + ", descricao = " + descricao + ", preco de unidade = " + precoUnit + "]";
    }
}
