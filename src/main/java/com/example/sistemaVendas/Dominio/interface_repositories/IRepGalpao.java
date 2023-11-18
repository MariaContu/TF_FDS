package com.example.sistemaVendas.Dominio.interface_repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;

public interface IRepGalpao {

    List<ItemEstoque> listarItensEstoqueNoGalpao();
    ItemEstoque obterItemEstoquePorId(long itemId);
    void atualizarItemEstoque(ItemEstoque itemEstoque);
    void removerItemEstoque(long itemId);
    
}