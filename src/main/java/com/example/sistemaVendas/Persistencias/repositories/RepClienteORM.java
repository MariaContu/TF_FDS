package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;

@Repository
public class RepClienteORM implements IRepCliente{

    @Override
    public Cliente findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    public List<Cliente> allClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allClientes'");
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
