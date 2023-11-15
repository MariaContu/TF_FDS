package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;

@Repository
public class RepItemEstoqueORM implements IRepItemEstoque{

    @Override
    public List<ItemEstoque> allItemEstoque() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allItemEstoque'");
    }

    @Override
    public ItemEstoque findItemEstoqueByProdutoID(long itemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findItemEstoqueByProdutoID'");
    }

    @Override
    public void addItemEstoque(ItemEstoque itemEstoque) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItemEstoque'");
    }

    @Override
    public void attQuantItemEstoque(ItemEstoque itemEstoque, int novaQuant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attQuantItemEstoque'");
    }

    @Override
    public void removeItemEstoque(ItemEstoque itemEstoque) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemEstoque'");
    }
    
}
