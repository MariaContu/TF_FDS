package com.example.sistemaVendas.Dominio.model;

import java.util.Date;

public class Orcamento {
    private long id;

    private Date data;
    private String nomeCliente;
    private Pedido pedido;
    private double custoPedido;
    private double imposto = 1.1; // imposto de 10%
    private double desconto = 0.95; //padrao para pedidos com mais de 5 itens
    private double valorFinal;
    private boolean valido=true;
    private boolean efetivado=false;

    public Orcamento(){}

    public Orcamento(long id, Date data, String nomeCliente, Pedido pedido)  {
        this.id=id;
        this.data=data;
        this.nomeCliente=nomeCliente;
        this.pedido=pedido;
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

    public boolean getValido()  {
        return valido;
    }

    public boolean getEfetivado()  {
        return efetivado;
    }

    public void setCustoPedido(double custoPedido) {
        this.custoPedido = custoPedido;
    }

    public void setValorFinal(double novoValor)   {
        this.valorFinal=novoValor;
    }

    public void setEfetivado(boolean efetivado) {
        this.efetivado = efetivado;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}