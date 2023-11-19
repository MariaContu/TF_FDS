package com.example.sistemaVendas.Dominio.interface_repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.ItemPedido;

public interface IRepPedido {

    List<Pedido> all();
    List<Pedido> pedidosPorCliente(long clienteID);

    void adicionarProd(long idPedido, List<ItemPedido> list);   
    void retirarProds(long idPedido, List<ItemPedido> itensRetirados);   

}