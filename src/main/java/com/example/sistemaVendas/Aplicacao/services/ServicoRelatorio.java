package com.example.sistemaVendas.Aplicacao.services;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.model.Orcamento;

public class ServicoRelatorio {
    private IRepCliente repCliente;
    private IRepOrcamentos repOrcamentos;
    private IRepProdutos repProdutos;

    public ServicoRelatorio(IRepCliente repCliente, IRepOrcamentos repOrcamentos, IRepProdutos repProdutos) {
        this.repCliente = repCliente;
        this.repOrcamentos = repOrcamentos;
        this.repProdutos = repProdutos;
    }

    public Relatorio analiseVendasPorProduto() {
        Relatorio relatorio = new Relatorio();
        relatorio.adicionarConteudo("Análise de Vendas por Produto:\n");

        for (Produto produto : repProdutos.all()) {
            int totalVendasProduto = calcularTotalVendasProduto(produto);
            relatorio.adicionarConteudo("Produto: " + produto.getDescricao() + ", Vendas: " + totalVendasProduto);
        }

        return relatorio;
    }

    private int calcularTotalVendasProduto(Produto produto) {
        int totalVendas = 0;
    
        for (Orcamento orcamento : repOrcamentos.all()) {
            for (ItemPedido produtoOrcamento : orcamento.getPedido().getListaProdutos()) {
                if (produtoOrcamento.getItemId() == produto.getCodigo()) {
                    totalVendas += produtoOrcamento.getItemQuant();
                }
            }
        }
    
        return totalVendas;
    }
    

    public Relatorio analiseDesempenhoCliente() {
        Relatorio relatorio = new Relatorio();
        relatorio.adicionarConteudo("Análise de Desempenho do Cliente:\n");

        for (Cliente cliente : repCliente.allClientes()) {
            double desempenhoCliente = calcularDesempenhoCliente(cliente);
            relatorio.adicionarConteudo("Cliente: " + cliente.getName() + ", Desempenho: " + desempenhoCliente);
        }

        return relatorio;
    }

    private double calcularDesempenhoCliente(Cliente cliente) {
        double desempenhoCliente = 0.0;
    
        // Verifique se há compras nos últimos seis meses
        if (cliente.getComprasUltimosSeisMeses() > 0) {
            // Calcule o valor médio das compras
            desempenhoCliente = cliente.getValorMedio() / cliente.getComprasUltimosSeisMeses();
        }
    
        return desempenhoCliente;
    }
}