package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;

public interface IRepItemEstoque {
    
    List<ItemEstoque> allItemEstoque();

    ItemEstoque findItemEstoqueByProdutoID(long itemId);

    void addItemEstoque(ItemEstoque itemEstoque);

    void attQuantItemEstoque(ItemEstoque itemEstoque,int novaQuant);

    void removeItemEstoque(ItemEstoque itemEstoque);

}
