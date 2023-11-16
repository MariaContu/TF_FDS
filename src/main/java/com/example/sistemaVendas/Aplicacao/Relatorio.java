package com.example.sistemaVendas.Aplicacao;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;

public class Relatorio {

    private List<Orcamento> orcamentos;
    private List<Pedido> pedidos;
    private List<Produto> produtos;

    public Relatorio(List<Orcamento> orcamentos, List<Pedido> pedidos, List<Produto> produtos) {
        this.orcamentos = orcamentos;
        this.pedidos = pedidos;
        this.produtos = produtos;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void adicionarOrcamento(Orcamento orcamento) {
        orcamentos.add(orcamento);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public void removerOrcamento(Orcamento orcamento) {
        orcamentos.remove(orcamento);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }
}
