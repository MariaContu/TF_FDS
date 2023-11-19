package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;


@Service
public class ServicoEstoque{
    private IRepGalpao produtosGalp;

    @Autowired
    public ServicoEstoque(IRepGalpao produtosGalp){
        this.produtosGalp = produtosGalp;
    }

    public List<ItemEstoque> produtosDisponiveis(){
        return produtosGalp.listarItensEstoqueNoGalpao();
    }

    public ItemEstoque findProdutoByID(long id){
        return produtosGalp.obterItemEstoquePorId(id);
    }

    public void retiraQuantItem(long idItem, int quantDesejada)    {
        produtosGalp.removerItemEstoquePorQntd(idItem, quantDesejada);
    }
    
}
