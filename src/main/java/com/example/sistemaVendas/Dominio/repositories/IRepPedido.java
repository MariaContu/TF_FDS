package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.ItemPedido;

public interface IRepPedido {

    List<Pedido> all();
    List<Pedido> pedidosPorCliente(long clienteID);

    void adicionarProd(long idPedido, ItemPedido novoItem);   
    void retirarProd(long idPedido, ItemPedido itemRetirado);   

}