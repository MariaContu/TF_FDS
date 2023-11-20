package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.interface_repositories.IRepPedido;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Pedido;

@Repository
public class RepPedidosMem implements IRepPedido{

    private List<Pedido> pedidos;
    @Autowired
    private IRepGalpao repGalpao;

    public RepPedidosMem(){
        pedidos = new LinkedList<>();
    }

    @Override
    public List<Pedido> all() {
        return pedidos;
    }

    @Override
    public List<Pedido> pedidosPorCliente(long clienteID) {
        List<Pedido> list = new LinkedList<>();
        for (Pedido ped : pedidos) {
            if(ped.getClienteId() == clienteID){
                list.add(ped);
            }
        }
        return list;
    }

    @Override
    public void adicionarProd(long idPedido, List<ItemPedido> listPed) {
        for (Pedido pedido : pedidos) {
            if(pedido.getId() == idPedido){
                for (ItemPedido item : listPed) {
                    repGalpao.removerItemEstoquePorQntd(item.getItemId(), item.getItemQuant());
                }
                pedido.setListaProdutos(listPed);
            }
        }
    }

    @Override
    public void retirarProds(long idPedido, List<ItemPedido> itensRetirados) {
        for (Pedido pedido : pedidos) {
            if(pedido.getId() == idPedido){
                pedido.getListaProdutos().removeAll(itensRetirados);
                for (ItemPedido item : itensRetirados) {
                    repGalpao.atualizarItemEstoque(item.getItemId(), (item.getItemQuant()+repGalpao.obterItemEstoquePorIdProduto(item.getItemId()).getQuantAtual()));
                }
            }
        }
    }
    
}
