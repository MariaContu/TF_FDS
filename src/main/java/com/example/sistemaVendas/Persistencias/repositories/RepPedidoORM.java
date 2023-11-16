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
        return new ArrayList<>(pedidos);
    }

    @Override
    public List<Pedido> pedidosPorCliente(long clienteID) {
        return pedidos.stream()
                .filter(pedido -> pedido.getClienteId() == clienteID)
                .collect(Collectors.toList());
    }

    @Override
    public void adicionarProd(long idPedido, ItemPedido novoItem) {
        Pedido pedido = findPedidoById(idPedido);
        if (pedido != null) {
            pedido.getListaProdutos().add(novoItem);
        }
    }

    @Override
    public void retirarProd(long idPedido, ItemPedido itemRetirado) {
        Pedido pedido = findPedidoById(idPedido);
        if (pedido != null) {
            pedido.getListaProdutos().remove(itemRetirado);
        }
    }

    // Método auxiliar para encontrar um Pedido pelo ID
    private Pedido findPedidoById(long id) {
        return pedidos.stream()
                .filter(pedido -> id == pedido.getId())
                .findFirst()
                .orElse(null);
    }
}
