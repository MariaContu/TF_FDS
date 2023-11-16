package com.example.sistemaVendas.Persistencias.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;

@Repository
public class RepItemEstoqueORM implements IRepItemEstoque {
    private List<ItemEstoque> itens;

    public RepItemEstoqueORM() {
        itens = new ArrayList<>();
    }

    @Override
    public List<ItemEstoque> allItemEstoque() {
        return new ArrayList<>(itens);
    }

    @Override
    public ItemEstoque findItemEstoqueByProdutoID(long codigoProduto) {
        return itens.stream()
                .filter(item -> codigoProduto == item.getCodigoProduto())
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addItemEstoque(ItemEstoque itemEstoque) {
        if (itemEstoque != null) {
            itens.add(itemEstoque);
        }
    }

    @Override
    public void attQuantItemEstoque(ItemEstoque itemEstoque, int novaQuant) {
        if (itemEstoque != null) {
            ItemEstoque encontrado = findItemEstoqueByProdutoID(itemEstoque.getCodigoProduto());
            if (encontrado != null) {
                encontrado.setQuantAtual(novaQuant);
            }
        }
    }

    @Override
    public void removeItemEstoque(ItemEstoque itemEstoque) {
        itens.removeIf(item -> item != null && item.getCodigoProduto() == itemEstoque.getCodigoProduto());
    }

}