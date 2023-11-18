package com.example.sistemaVendas.Dominio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date data;
    private String nomeCliente;
    private Pedido pedido;
    private double custoPedido;
    private double imposto = 1.1; // imposto de 10%
    private double desconto = 0.95; //padrao para pedidos com mais de 5 itens
    private double valorFinal;

    public Orcamento(long id, Date data, String nomeCliente, Pedido pedido, double custoPedido, double valorFinal)  {
        this.id=id;
        this.data=data;
        this.nomeCliente=nomeCliente;
        this.pedido=pedido;
        this.custoPedido=custoPedido;
        this.valorFinal=valorFinal;
    }

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getCustoPedido() {
        return custoPedido;
    }
    
    public double getDesconto() {
        return desconto;
    }

    public double getImposto() {
        return imposto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double novoValor)   {
        this.valorFinal=novoValor;
    }
}