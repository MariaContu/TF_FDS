package com.example.sistemaVendas.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.ServicoEstoque;
import com.example.sistemaVendas.Dominio.entidades.Produto;

@Component
public class ProdutosDisponiveis_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public List<Produto> run(){
        return servicoEstoque.produtosDisponiveis();
    }

}
