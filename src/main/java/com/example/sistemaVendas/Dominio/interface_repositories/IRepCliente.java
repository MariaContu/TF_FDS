package com.example.sistemaVendas.Dominio.interface_repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Orcamento;

public interface IRepCliente {

    Cliente findByName(String name);
    List<Cliente> allClientes();

    void calculaValorMedio(Cliente cliente);
    double calculaDescontoUltimosSeisMeses(Cliente cliente);

    double descontoDeCliente(Cliente cliente);

    void addPedido(Cliente cliente, Orcamento orcamento);

    void atualizaValorMedio(Cliente cliente);
    void atualizaComprasUltimosMeses(Cliente cliente);

}