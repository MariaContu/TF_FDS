package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Cliente;

public interface IRepCliente {

    Cliente findByName(String name);
    List<Cliente> allClientes();

<<<<<<< HEAD
    void calculaValorMedio(Cliente cliente);
    double calculaDescontoUltimosSeisMeses(Cliente cliente);

    double descontoDeCliente(Cliente cliente);
=======
    void attValorMedio(Cliente cliente, double valorNovo);
    void attComprasSeisMeses(Cliente cliente, int countMeses);
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046

}