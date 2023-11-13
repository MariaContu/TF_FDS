package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;

@Service
public class ServicoEstoque{
    private IRepProdutos produtosRep;
    private IRepItemEstoque itemEstoqueRep;

    @Autowired
    public ServicoEstoque(IRepProdutos produtosRep, IRepItemEstoque itemEstoqueRep){
        this.produtosRep = produtosRep;
        this.itemEstoqueRep=itemEstoqueRep;

    }

    public List<Produto> produtosDisponiveis(){
        return produtosRep.all();    }
}
