package com.example.sistemaVendas.Dominio.interface_repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;

public interface IRepGalpao {

    List<ItemEstoque> listarItensEstoqueNoGalpao();
    ItemEstoque obterItemEstoquePorIdProduto(long itemId);
    void atualizarItemEstoque(long idItem, int qntItem);
    void removerItemEstoquePorQntd(long itemId, int qntItem);
    
}