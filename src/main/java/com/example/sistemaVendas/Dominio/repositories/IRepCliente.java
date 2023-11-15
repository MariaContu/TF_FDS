package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Cliente;

public interface IRepCliente {

    Cliente findByName(String name);
    List<Cliente> allClientes();

    void attValorMedio(Cliente cliente, double valorNovo);
    void attComprasSeisMeses(Cliente cliente, int countMeses);

}