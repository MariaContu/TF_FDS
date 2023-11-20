package com.example.sistemaVendas.Aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@Component
public class ProdutosDisponiveis_UC {
    @Autowired
    private ServicoEstoque servicoEstoque;
    @Autowired
    private ServicoVendas servicoVendas;

    public List<ItemEstoque> verItens(){
        return servicoEstoque.itensDisponiveis();
    }

    public List<Produto> verProdutos(){
        return servicoEstoque.produtosDisponiveis();
    }

    public ItemEstoque byId(long id){
        return servicoEstoque.findProdutoByID(id);
    }

    public List<Pedido> itens(){
        return servicoVendas.listarTodosPedidos();
    }

}
