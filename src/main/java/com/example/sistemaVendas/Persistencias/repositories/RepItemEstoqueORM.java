package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;

@Repository
public class RepItemEstoqueORM implements IRepItemEstoque{
    private List<ItemEstoque> itensEstoque;

    public RepItemEstoqueORM()  {
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
        itensEstoque.add(new ItemEstoque(11,11,200,20,150));
    }

    @Override
    public List<ItemEstoque> allItemEstoque() {
        return itensEstoque;
    }

    @Override
    public ItemEstoque findItemEstoqueByProdutoID(long itemId) {
        for (ItemEstoque i : itensEstoque) {
            if (itemId==i.getCodigoProduto()) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void addItemEstoque(ItemEstoque itemEstoque) {
        itensEstoque.add(itemEstoque);
    }

    @Override
    public void retiraQuantItem(ItemEstoque item, int quantDesejada) {
        if (item.getQuantAtual()-quantDesejada>=item.getQuantMin() && quantDesejada<=item.getQuantAtual()) {
            item.setQuantAtual(item.getQuantAtual()-quantDesejada);
        }
        else System.out.println("Quantidade Desejada Invalida");
    }    
}
