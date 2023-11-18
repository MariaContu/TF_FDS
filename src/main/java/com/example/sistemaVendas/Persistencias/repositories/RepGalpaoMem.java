package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;

@Repository
public class RepGalpaoMem implements IRepGalpao{

    private List<ItemEstoque> galpao;

    public RepGalpaoMem(){
        galpao = new LinkedList<>();
        galpao.add(new ItemEstoque(10, 100, 10, 50));
        galpao.add(new ItemEstoque(20, 100, 10, 50));
    }

    @Override
    public List<ItemEstoque> listarItensEstoqueNoGalpao() {
        return galpao;
    }

    @Override
    public ItemEstoque obterItemEstoquePorId(long itemId) {
       for (ItemEstoque item : galpao) {
            if(item.getId() == itemId){
                return item;
            }
       }
       return null;
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
