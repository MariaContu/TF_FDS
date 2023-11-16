package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.model.Cliente;

@Service
public class ServicoCliente {

    private IRepCliente repCliente;

    public ServicoCliente(IRepCliente repCliente) {
        this.repCliente = repCliente;
    }

    public Cliente findClienteByName(String name) {
        return repCliente.findByName(name);
    }

    public List<Cliente> findAllClientes() {
        return repCliente.allClientes();
    }

    public void calculaValorMedio(Cliente cliente)  {
        repCliente.calculaValorMedio(cliente);
    }
    
    public void calculaDescontoUltimosSeisMeses(Cliente cliente){
        repCliente.calculaDescontoUltimosSeisMeses(cliente);
    }
}