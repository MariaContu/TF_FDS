package com.example.sistemaVendas.Dominio;

import java.util.List;

import com.example.sistemaVendas.Dominio.entidades.Produto;

public interface IRepProdutos {
    void save(Produto p);
    List<Produto> all();
}
