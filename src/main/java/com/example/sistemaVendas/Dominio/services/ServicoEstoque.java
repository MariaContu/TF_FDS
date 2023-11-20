package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.interface_repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.Produto;


@Service
public class ServicoEstoque{
    private IRepGalpao produtosGalp;
    private IRepProdutos produtos;

    @Autowired
    public ServicoEstoque(IRepGalpao produtosGalp, IRepProdutos produtos){
        this.produtosGalp = produtosGalp;
        this.produtos = produtos;
    }

    public List<ItemEstoque> itensDisponiveis(){
        return produtosGalp.listarItensEstoqueNoGalpao();
    }

    public List<Produto> produtosDisponiveis(){
        return produtos.all();
    }

    public ItemEstoque findProdutoByID(long id){
        return produtosGalp.obterItemEstoquePorIdProduto(id);
    }

    public void retiraQuantItem(long idItem, int quantDesejada)    {
        produtosGalp.removerItemEstoquePorQntd(idItem, quantDesejada);
    }
    
}
