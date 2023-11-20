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
        galpao.add(new ItemEstoque(1,1,200,20,150));
        galpao.add(new ItemEstoque(2,2,200,20,150));
        galpao.add(new ItemEstoque(3,3,200,20,150));
        galpao.add(new ItemEstoque(4,4,200,20,150));
        galpao.add(new ItemEstoque(5,5,200,20,150));
        galpao.add(new ItemEstoque(6,6,200,20,150));
        galpao.add(new ItemEstoque(7,7,200,20,150));
        galpao.add(new ItemEstoque(8,8,200,20,150));
        galpao.add(new ItemEstoque(9,9,200,20,150));
        galpao.add(new ItemEstoque(10,10,200,20,150));
        galpao.add(new ItemEstoque(11,11,200,20,150));
    }

    @Override
    public List<ItemEstoque> listarItensEstoqueNoGalpao() {
        return galpao;
    }

    @Override
    public ItemEstoque obterItemEstoquePorIdProduto(long itemId) {
       for (ItemEstoque item : galpao) {
            if(item.getId() == itemId){
                return item;
            }
       }
       return null;
    }

    @Override
    public void atualizarItemEstoque(long idItemEstoque, int qntItem) {
        for (ItemEstoque item : galpao) {
            if(item.getCodigoProduto() == idItemEstoque){
                item.setQuantAtual(qntItem);
            }
        }
    }

    @Override
    public void removerItemEstoquePorQntd(long idItem, int qntItem) {
        for (ItemEstoque item : galpao) {
            if(item.getCodigoProduto() == idItem){
                if(item.getQuantAtual()-qntItem <= item.getQuantMin()){
                    atualizarItemEstoque(idItem, item.getQuantMin());
                }else{
                    item.setQuantAtual(item.getQuantAtual()-qntItem);
                }
            }
        }
    }
    
}
