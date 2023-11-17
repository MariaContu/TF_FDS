package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;

public interface IRepRelatorio {

    void gerarRelatorioCliente(Cliente cliente);
    void gerarRelatorioGalpao(Galpao galpao, ItemEstoque item);
    void gerarRelatorioItemEstoque(ItemEstoque itemEstoque);
    void gerarRelatorioItemPedido(ItemPedido itemPedido);
    void gerarRelatorioOrcamento(Orcamento orcamento);
    void gerarRelatorioPedido(Pedido pedido);
    void gerarRelatorioProduto(Produto produto);

    void salvarRelatorio(Relatorio relatorio);

    List<Relatorio> listarTodosRelatorios();

    Relatorio encontrarPorCliente(Cliente cliente);

    void removerRelatorio(long id);
}
