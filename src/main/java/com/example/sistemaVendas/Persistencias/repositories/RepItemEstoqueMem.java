package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;

@Repository
public class RepItemEstoqueMem implements IRepItemEstoque{

    @Override
    public List<ItemEstoque> listarItensEstoque() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarItensEstoque'");
    }

    @Override
    public ItemEstoque obterItemEstoquePorId(long itemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterItemEstoquePorId'");
    }

    @Override
    public void adicionarItemEstoque(ItemEstoque itemEstoque) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarItemEstoque'");
    }

    @Override
    public void atualizarItemEstoque(ItemEstoque itemEstoque) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarItemEstoque'");
    }

    @Override
    public void removerItemEstoque(long itemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerItemEstoque'");
    }
    
}
