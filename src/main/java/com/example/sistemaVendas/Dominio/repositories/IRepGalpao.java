package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.Produto;

public interface IRepGalpao {

    List<Produto> listAllProdutos();
    Produto findById(long id);
    
    void addGalpao(Galpao galpao);
    
}