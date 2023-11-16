package com.example.sistemaVendas.Persistencias.repositories;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
=======
import java.util.List;
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.repositories.IRepPedido;

@Repository
<<<<<<< HEAD
public class RepPedidoORM implements IRepPedido {

    private List<Pedido> pedidos;

    public RepPedidoORM() {
        pedidos = new ArrayList<>();
    }

    @Override
    public List<Pedido> all() {
        return new ArrayList<>(pedidos);
=======
public class RepPedidoORM implements IRepPedido{

    @Override
    public List<Pedido> all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'all'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public List<Pedido> pedidosPorCliente(long clienteID) {
<<<<<<< HEAD
        return pedidos.stream()
                .filter(pedido -> pedido.getClienteId() == clienteID)
                .collect(Collectors.toList());
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pedidosPorCliente'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public void adicionarProd(long idPedido, ItemPedido novoItem) {
<<<<<<< HEAD
        Pedido pedido = findPedidoById(idPedido);
        if (pedido != null) {
            pedido.getListaProdutos().add(novoItem);
        }
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarProd'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public void retirarProd(long idPedido, ItemPedido itemRetirado) {
<<<<<<< HEAD
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
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retirarProd'");
    }
    
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
}
