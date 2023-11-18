package com.example.sistemaVendas.Dominio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;

    private String descricao;
    private double precoUnit;

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
