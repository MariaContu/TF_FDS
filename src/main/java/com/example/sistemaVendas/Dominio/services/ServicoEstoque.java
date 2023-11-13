package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.model.Produto;

@Service
public class ServicoEstoque{
    private IRepProdutos produtosRep;

    @Autowired
    public ServicoEstoque(IRepProdutos produtosRep){
        this.produtosRep = produtosRep;
    }

    public List<Produto> produtosDisponiveis(){
        return produtosRep.all();
    }
}
