package com.example.sistemaVendas.Aplicacao.services;

import java.util.List;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepRelatorio;

public class ServicoRelatorio {

    private IRepRelatorio repRelatorio;

    public void gerarRelatorioCliente(Cliente cliente){
        repRelatorio.gerarRelatorioCliente(cliente);
    }

    public void gerarRelatorioGalpao(Galpao galpao, ItemEstoque item){
        repRelatorio.gerarRelatorioGalpao(galpao, item);
    }

    public void gerarRelatorioItemEstoque(ItemEstoque itemEstoque){
        repRelatorio.gerarRelatorioItemEstoque(itemEstoque);
    }

    public void gerarRelatorioItemPedido(ItemPedido itemPedido){
        repRelatorio.gerarRelatorioItemPedido(itemPedido);
    }

    public void gerarRelatorioOrcamento(Orcamento orcamento){
         repRelatorio.gerarRelatorioOrcamento(orcamento);
    }

    public void gerarRelatorioPedido(Pedido pedido){
        repRelatorio.gerarRelatorioPedido(pedido);
    }

    public void gerarRelatorioProduto(Produto produto){
        repRelatorio.gerarRelatorioProduto(produto);
    }

    public void salvarNovoRelatorio(Relatorio novoRelatorio){
        repRelatorio.salvarRelatorio(novoRelatorio);
    }

    public List<Relatorio> obterTodosOsRelatorios(){
        return repRelatorio.listarTodosRelatorios();
    }

    public Relatorio encontrarRelatorioPorCliente(Cliente cliente){
        return repRelatorio.encontrarPorCliente(cliente);
    }

    public void removerRelatorioExistente(long id){
        repRelatorio.removerRelatorio(id);
    }
}