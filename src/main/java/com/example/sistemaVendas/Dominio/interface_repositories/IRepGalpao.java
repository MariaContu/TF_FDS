package com.example.sistemaVendas.Dominio.interface_repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Produto;

public interface IRepGalpao {

    List<Produto> listAllProdutos();
    Produto findById(long id);
    
}