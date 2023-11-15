package com.example.sistemaVendas.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.services.ServicoCliente;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;

@Component
public class ProdutosDisponiveis {
    @Autowired
    private ServicoEstoque servicoEstoque;
    private ServicoCliente servicoCliente;

    public List<Produto> all(){
        return servicoEstoque.listarTodosProdutos();
    }

    public Produto findByID(long id)   {
        return servicoEstoque.encontrarProdutoPorId(id);
    }
}
