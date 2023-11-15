package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.Produto;

public interface IRepGalpao {

    List<ItemEstoque> listAllProdutos();
    ItemEstoque findById(long id);

}