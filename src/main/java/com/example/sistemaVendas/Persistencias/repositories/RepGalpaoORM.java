package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepGalpao;

@Repository
public class RepGalpaoORM implements IRepGalpao {
    private List<ItemEstoque> itensEstoque;

    public RepGalpaoORM()  {
        itensEstoque = new LinkedList<>();
        itensEstoque.add(new ItemEstoque(1,1,200,20,150));
        itensEstoque.add(new ItemEstoque(2,2,200,20,150));
        itensEstoque.add(new ItemEstoque(3,3,200,20,150));
        itensEstoque.add(new ItemEstoque(4,4,200,20,150));
        itensEstoque.add(new ItemEstoque(5,5,200,20,150));
        itensEstoque.add(new ItemEstoque(6,6,200,20,150));
        itensEstoque.add(new ItemEstoque(7,7,200,20,150));
        itensEstoque.add(new ItemEstoque(8,8,200,20,150));
        itensEstoque.add(new ItemEstoque(9,9,200,20,150));
        itensEstoque.add(new ItemEstoque(10,10,200,20,150));
    }

    @Override
    public List<ItemEstoque> listAllProdutos() {
        return itensEstoque;
    }

    @Override
    public ItemEstoque findById(long id) {
        for (ItemEstoque i : itensEstoque) {
            if (id==i.getCodigoProduto()) {
                return i;
            }
        }
        return null;
    }
}