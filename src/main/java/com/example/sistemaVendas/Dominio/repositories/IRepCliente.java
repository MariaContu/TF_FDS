package com.example.sistemaVendas.Dominio.repositories;

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
    void atualizaComprasUltimosMeses(Cliente cliente);
    void atualizaValorMedio(Cliente cliente);

}