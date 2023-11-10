package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;

public interface IRepItemEstoque {
    
    List<ItemEstoque> listarItensEstoque();

    ItemEstoque obterItemEstoquePorId(long itemId);

    void adicionarItemEstoque(ItemEstoque itemEstoque);

    void atualizarItemEstoque(ItemEstoque itemEstoque);

    void removerItemEstoque(long itemId);

}
