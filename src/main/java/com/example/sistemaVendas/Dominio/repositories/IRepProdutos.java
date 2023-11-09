package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Produto;

public interface IRepProdutos {
    void save(Produto p);
    List<Produto> all();
}
