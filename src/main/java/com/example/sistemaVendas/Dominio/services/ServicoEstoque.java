package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;

@Service

public class ServicoEstoque {

    private IRepProdutos repProdutos;
    private IRepItemEstoque repItemEstoque;
    private IRepGalpao repGalpao;

    public ServicoEstoque(IRepProdutos repProdutos, IRepItemEstoque repItemEstoque, IRepGalpao repGalpao) {
        this.repProdutos = repProdutos;
        this.repItemEstoque = repItemEstoque;
        this.repGalpao = repGalpao;
    }

    public List<Produto> listarTodosProdutos() {
        return repProdutos.all();
    }

    public Produto encontrarProdutoPorId(long id) {
        return repProdutos.findById(id);
    }

    public List<ItemEstoque> listarTodosItensEstoque() {
        return repItemEstoque.allItemEstoque();
    }

    public ItemEstoque encontrarItemEstoquePorProdutoID(long itemId) {
        return repItemEstoque.findItemEstoqueByProdutoID(itemId);
    }

    public void adicionarItemEstoque(ItemEstoque itemEstoque) {
        repItemEstoque.addItemEstoque(itemEstoque);
    }

    public void atualizarQuantidadeItemEstoque(ItemEstoque itemEstoque, int novaQuant) {
        repItemEstoque.attQuantItemEstoque(itemEstoque, novaQuant);
    }

    public void removerItemEstoque(ItemEstoque itemEstoque) {
        repItemEstoque.removeItemEstoque(itemEstoque);
    }

    public void addGalpao(Galpao galpao)    {
        repGalpao.addGalpao(galpao);
    }
}
