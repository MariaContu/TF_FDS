package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;

@Repository
public class RepGalpaoORM implements IRepGalpao {
    private IRepItemEstoque repItemEstoque;

    public RepGalpaoORM()  {
    
    }

    @Override
    public List<ItemEstoque> listAllProdutos() {
        return repItemEstoque.allItemEstoque();
    }

    @Override
    public ItemEstoque findById(long id) {
        for (ItemEstoque i : repItemEstoque.allItemEstoque()) {
            if (id==i.getCodigoProduto()) {
                return i;
            }
        }
        return null;
    }
}
