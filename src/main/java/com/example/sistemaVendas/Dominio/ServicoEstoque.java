package com.example.sistemaVendas.Dominio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.entidades.Produto;

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
