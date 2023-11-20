package com.example.sistemaVendas.Dominio.model;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Pedido {
    private long id;

    private long clienteId;

    private List<ItemPedido> listaProdutos;

    public Pedido(long id, long clienteId, List<ItemPedido> listaProdutos)   {
        this.id=id;
        this.clienteId=clienteId;
        this.listaProdutos=listaProdutos;
    }

    public long getId() {
        return id;
    }

    public long getClienteId() {
        return clienteId;
    }

    public List<ItemPedido> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ItemPedido> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }   

}
