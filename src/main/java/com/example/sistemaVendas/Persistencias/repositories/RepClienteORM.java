package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;

@Repository
public class RepClienteORM implements IRepCliente{
    public List<Cliente> clientes;

    public RepClienteORM()  {
        clientes = new LinkedList<>();
        clientes.add(new Cliente(1,"Ana", 0, 0));
        clientes.add(new Cliente(2,"Joaquim", 0, 0));
        clientes.add(new Cliente(3,"Fernanda", 0, 0));
        clientes.add(new Cliente(4,"Augusto", 0, 0));
        clientes.add(new Cliente(5,"Joao", 0, 0));
        clientes.add(new Cliente(6,"Amanda", 0, 0));
        clientes.add(new Cliente(7,"Yasmin", 0, 0));
        clientes.add(new Cliente(8,"Lucas", 0, 0));
    }

    @Override
    public Cliente findByName(String name) {
        for (Cliente c : clientes) {
            if (name.toUpperCase().equals(c.getName().toUpperCase())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> allClientes() {
        return clientes;
    }

    @Override
    public void calculaValorMedio(Cliente cliente) {
        if (!cliente.getOrcamentos().isEmpty() && cliente.getOrcamentos().size()>=3) {
            List<Orcamento> ultimos3pedidos = cliente.getOrcamentos().subList(cliente.getOrcamentos().size() -3, cliente.getOrcamentos().size());
        
            double soma=0;
            for (Orcamento p : ultimos3pedidos) {
                soma+=p.getValorFinal();
            }

            cliente.setValorMedio(soma/3);
        }
        else {
            double soma=0;
            for (Orcamento o : cliente.getOrcamentos()) {
                soma+=o.getValorFinal();
            }
            cliente.setValorMedio(soma/3);
        }
    }

    @Override
    public void calculaDescontoUltimosSeisMeses(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculaDescontoUltimosSeisMeses'");
    }
    
}
