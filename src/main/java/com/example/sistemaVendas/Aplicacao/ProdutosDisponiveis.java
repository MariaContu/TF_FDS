package com.example.sistemaVendas.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;

@Component
public class ProdutosDisponiveis {
    @Autowired
    private ServicoEstoque servicoEstoque;

    public List<Produto> all(){
        return servicoEstoque.listarTodosProdutos();
    }

}
