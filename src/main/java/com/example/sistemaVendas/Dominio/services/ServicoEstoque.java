package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;
<<<<<<< HEAD
=======
import com.example.sistemaVendas.Dominio.repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.model.Galpao;
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
import com.example.sistemaVendas.Dominio.model.ItemEstoque;

@Service
public class ServicoEstoque {

    private IRepProdutos repProdutos;
    private IRepItemEstoque repItemEstoque;
<<<<<<< HEAD

    public ServicoEstoque(IRepProdutos repProdutos, IRepItemEstoque repItemEstoque) {
        this.repProdutos = repProdutos;
        this.repItemEstoque = repItemEstoque;
=======
    private IRepGalpao repGalpao;

    public ServicoEstoque(IRepProdutos repProdutos, IRepItemEstoque repItemEstoque, IRepGalpao repGalpao) {
        this.repProdutos = repProdutos;
        this.repItemEstoque = repItemEstoque;
        this.repGalpao = repGalpao;
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
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

<<<<<<< HEAD
=======
    public void addGalpao(Galpao galpao)    {
        repGalpao.addGalpao(galpao);
    }
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
}
