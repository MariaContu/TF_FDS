package com.example.sistemaVendas.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;

@Component
public class ProdutosDisponiveis_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public List<Produto> run(){
        return servicoEstoque.produtosDisponiveis();
    }

    public Produto byId(long id){
        return servicoEstoque.findProdutoByID(id);
    }

}
