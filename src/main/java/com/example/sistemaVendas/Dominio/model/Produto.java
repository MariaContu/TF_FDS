package com.example.sistemaVendas.Dominio.model;


public class Produto {

    private long codigo;
<<<<<<< HEAD
=======

>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
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

<<<<<<< HEAD
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    @Override
    public String toString() {
        return "Produto [codigo = " + codigo + ", descricao = " + descricao + ", preco de unidade = " + precoUnit + "]";
    }
}
