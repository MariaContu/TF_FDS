package com.example.sistemaVendas.Aplicacao;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServicoRelatorio {

    private ServicoVendas servicoVendas;
    private ServicoEstoque servicoEstoque;
    private Relatorio relatorio;

    public ServicoRelatorio(ServicoVendas servicoVendas, ServicoEstoque servicoEstoque,Relatorio relatorio) {
        this.servicoVendas = servicoVendas;
        this.servicoEstoque = servicoEstoque;
        this.relatorio = relatorio;
    }

    // Métodos para adicionar dados ao relatório

    public void adicionarPedidoAoRelatorio(Pedido pedido) {
        relatorio.adicionarPedido(pedido);
    }

    public void adicionarOrcamentoAoRelatorio(Orcamento orcamento) {
        relatorio.adicionarOrcamento(orcamento);
    }

    public void adicionarProdutoAoRelatorio(Produto produto) {
        relatorio.adicionarProduto(produto);
    }

    public void removerPedidoDoRelatorio(Pedido pedido) {
        relatorio.removerPedido(pedido);
    }

    public void removerOrcamentoDoRelatorio(Orcamento orcamento) {
        relatorio.removerOrcamento(orcamento);
    }

    public void removerProdutoDoRelatorio(Produto produto) {
        relatorio.removerProduto(produto);
    }

    public List<Orcamento> obterOrcamentosDoRelatorio() {
        return servicoVendas.listarTodosOrcamentos();
    }

    public List<Pedido> obterPedidosDoRelatorio() {
        return servicoVendas.listarTodosPedidos();
    }

    public List<Produto> obterProdutosDoRelatorio() {
        return servicoEstoque.listarTodosProdutos();
    }

    public List<Orcamento> filtrarOrcamentosPorCliente(long clienteId) {
        return servicoVendas.listarTodosOrcamentos().stream()
                .filter(o -> o.getPedido().getClienteId() == clienteId)
                .toList();
    }

    public List<Pedido> filtrarPedidosPorCliente(long clienteId) {
        return servicoVendas.listarPedidosPorCliente(clienteId);
    }

    public double calcularTotalOrcamentos() {
        return servicoVendas.listarTodosOrcamentos().stream()
                .mapToDouble(Orcamento::getValorFinal)
                .sum();
    }
}
