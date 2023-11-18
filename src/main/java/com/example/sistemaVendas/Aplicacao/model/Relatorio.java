package com.example.sistemaVendas.Aplicacao.model;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;

public class Relatorio {

    private List<Cliente> clientes;
    private List<Galpao> galpoes;
    private List<ItemEstoque> itensEstoque;
    private List<ItemPedido> itensPedidos;
    private List<Orcamento> orcamentos;
    private List<Pedido> pedidos;
    private List<Produto> produtos;
    
    public Relatorio(List<Cliente> clientes, List<Galpao> galpoes, List<ItemEstoque> itensEstoque,
            List<ItemPedido> itensPedidos, List<Orcamento> orcamentos, List<Pedido> pedidos, List<Produto> produtos) {
        this.clientes = clientes;
        this.galpoes = galpoes;
        this.itensEstoque = itensEstoque;
        this.itensPedidos = itensPedidos;
        this.orcamentos = orcamentos;
        this.pedidos = pedidos;
        this.produtos = produtos;
    }

    private String conteudo;

    public Relatorio(){}
    
    public Relatorio(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Galpao> getGalpoes() {
        return galpoes;
    }

    public void setGalpoes(List<Galpao> galpoes) {
        this.galpoes = galpoes;
    }

    public List<ItemEstoque> getItensEstoque() {
        return itensEstoque;
    }

    public void setItensEstoque(List<ItemEstoque> itensEstoque) {
        this.itensEstoque = itensEstoque;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

    public void setOrcamentos(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Cliente> getListaClientes() {
        return clientes;
    }

    public List<Galpao> getListaGalpoes() {
        return galpoes;
    }

    public List<ItemEstoque> getListaItensEstoque() {
        return itensEstoque;
    }

    public List<ItemPedido> getListaItensPedido() {
        return itensPedidos;
    }

    public List<Orcamento> getListaOrcamento() {
        return orcamentos;
    }

    public List<Pedido> getListaPedidos() {
        return pedidos;
    }

    public List<Produto> getListaProdutos() {
        return produtos;
    }

    public String getConteudo() {
        return conteudo;
    }
}
