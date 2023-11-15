package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Cliente;
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
    public void attValorMedio(Cliente cliente, double valorNovo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attValorMedio'");
    }

    @Override
    public void attComprasSeisMeses(Cliente cliente, int countMeses) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attComprasSeisMeses'");
    }
    
}
