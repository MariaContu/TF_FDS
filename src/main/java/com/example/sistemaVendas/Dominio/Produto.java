package com.example.sistemaVendas.Dominio;

public class Produto {
    private double preco_unitario;
    private int id;
    private String descricao;

    public Produto(int id, String descricao, double preco_unitario){
        this.preco_unitario = preco_unitario;
        this.id = id;
        this.descricao = descricao;
    }

    public double getPreco(){
        return preco_unitario;
    }

    public void setPreco(double novoPreco){
        this.preco_unitario = novoPreco;
    }

    public int getId(){
        return id;
    }

    public String getDescricao(){
        return descricao;
    }

    public String toString(){
        return "Produto "+id+" - "+descricao+ "; Preco por unidade: "+preco_unitario;
    }

}
