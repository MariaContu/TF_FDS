package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepGalpao;

@Repository
public class RepGalpaoORM implements IRepGalpao {
    private List<ItemEstoque> itens;

    public RepGalpaoORM()  {
        itens = new LinkedList<>();
    }

    @Override
    public List<ItemEstoque> listAllProdutos() {
        return itens;
    }

    @Override
    public ItemEstoque findById(long id) {
        for (ItemEstoque i : itens) {
            if (id==i.getCodigoProduto()) {
                return i;
            }
        }
        return null;
    }
}
