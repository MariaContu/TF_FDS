package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.repositories.IRepPedido;

@Repository
public class RepPedidoORM implements IRepPedido{
    private List<Pedido> pedidos;

    public RepPedidoORM()   {
        pedidos=new LinkedList<>();
    }

    @Override
    public List<Pedido> all() {
        return pedidos;
    }

    @Override
    public List<Pedido> pedidosPorCliente(long clienteID) {
        List<Pedido> pedidosCliente = new LinkedList<>();

        for (Pedido pedido : pedidos) {
            if (clienteID == pedido.getClienteId()) {
                pedidosCliente.add(pedido);
            }
        }

        return pedidosCliente;
    }

    @Override
    public void adicionarProd(long idPedido, ItemPedido novoItem) {
    
        for (Pedido p : pedidos) {
            if (idPedido==p.getId()) {
                //dentro do pedido
                List<ItemPedido> listaPedido=p.getListaProdutos();
                listaPedido.add(novoItem);
                p.setListaProdutos(listaPedido);
            }
        }
    }

    @Override
    public void retirarProd(long idPedido, ItemPedido itemRetirado) {
        for (Pedido p : pedidos) {
            if (idPedido==p.getId()) {
                //dentro do pedido
                List<ItemPedido> listaPedido=p.getListaProdutos();
                listaPedido.remove(itemRetirado);
                p.setListaProdutos(listaPedido);
            }
        }
    }
    
}
