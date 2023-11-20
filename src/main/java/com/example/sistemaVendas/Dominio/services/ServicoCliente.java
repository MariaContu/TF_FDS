package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Orcamento;

@Service
public class ServicoCliente {
    private IRepCliente repCliente;

    public ServicoCliente(IRepCliente repCliente) {
        this.repCliente = repCliente;
    }

    public Cliente findClienteByName(String name) {
        return repCliente.findByName(name);
    }

    public Cliente findClienteById(long id) {
        return repCliente.findById(id);
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
    public void addPedido(Cliente cliente, Orcamento orcamento)  {
        repCliente.addPedido(cliente, orcamento);
    }

    public void atualizaComprasUltimosMeses(Cliente cliente)    {
        repCliente.atualizaComprasUltimosMeses(cliente);
    }

    public void atualizaValorMedio(Cliente cliente)    {
        repCliente.atualizaValorMedio(cliente);
    }
}
