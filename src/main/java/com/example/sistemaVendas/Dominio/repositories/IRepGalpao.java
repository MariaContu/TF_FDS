package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;

public interface IRepGalpao {

    List<ItemEstoque> listAllProdutos();
    ItemEstoque findById(long id);

}