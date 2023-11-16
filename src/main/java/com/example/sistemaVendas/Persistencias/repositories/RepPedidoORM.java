package com.example.sistemaVendas.Persistencias.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.repositories.IRepPedido;

@Repository
public class RepPedidoORM implements IRepPedido {

    private List<Pedido> pedidos;

    public RepPedidoORM() {
        pedidos = new ArrayList<>();
    }

    @Override
    public List<Pedido> all() {
        return pedidos;
    }

    @Override
    public List<Pedido> pedidosPorCliente(long clienteID) {
        return pedidos.stream()
                .filter(pedido -> pedido.getClienteId() == clienteID)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionarProd(long idPedido, ItemPedido novoItem) {
        Pedido pedido = encontrarPedidoPorId(idPedido);
        if (pedido != null) {
            pedido.getListaProdutos().add(novoItem);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    @Override
    public void retirarProd(long idPedido, ItemPedido itemRetirado) {
        Pedido pedido = encontrarPedidoPorId(idPedido);
        if (pedido != null) {
            pedido.getListaProdutos().remove(itemRetirado);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private Pedido encontrarPedidoPorId(long idPedido) {
        return pedidos.stream()
                .filter(pedido -> pedido.getId() == idPedido)
                .findFirst()
                .orElse(null);
    }
}
