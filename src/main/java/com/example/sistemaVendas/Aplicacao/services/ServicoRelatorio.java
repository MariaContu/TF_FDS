package com.example.sistemaVendas.Aplicacao.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public String calculaCustoMedioOrcamentos() {
        List<Orcamento> orcamentos = repOrcamentos.all();
        double custoTotal = 0;
        double custoFinal = 0;
        List<Double> vendasMensais = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");

        if (orcamentos != null && !orcamentos.isEmpty()) {
            vendasMensais = listaVendasMensais(); // Inicializa uma lista com 12 elementos zerados

            for (Orcamento orcamento : orcamentos) {
                custoTotal += orcamento.getCustoPedido();
                custoFinal += orcamento.getValorFinal();
                int mes = Integer.parseInt(dateFormat.format(orcamento.getData()));
                double vendaTotal = orcamento.getValorFinal();

                vendasMensais.set(mes - 1, vendasMensais.get(mes - 1) + vendaTotal);
            }

            int monthWithHighestSales = mesVendasMaximas(vendasMensais);

            String message = String.format("A quantidade total de orçamentos é de: %d.\n", orcamentos.size())
                    + String.format("A média do custo total dos orçamentos cadastrados é: R$%.2f.\n",
                            custoTotal / orcamentos.size())
                    + String.format("A média do custo final dos orçamentos cadastrados é: R$%.2f.\n",
                            custoFinal / orcamentos.size())
                    + String.format("O mês %d é o mês com mais vendas.\n", monthWithHighestSales);

            return message;
        }

        return "A quantidade total de orçamentos é de: 0.\n"
                + "A média do custo total dos orçamentos cadastrados é: R$0.\n"
                + "A média do custo final dos orçamentos cadastrados é: R$0.\n";
    }

    private List<Double> listaVendasMensais() {
        List<Double> monthlySales = new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            monthlySales.add(0.0);
        }
        return monthlySales;
    }

    private int mesVendasMaximas(List<Double> monthlySales) {
        int monthWithMaxSales = 0;
        double maxSales = Double.MIN_VALUE;

        for (int i = 0; i < monthlySales.size(); i++) {
            if (monthlySales.get(i) > maxSales) {
                maxSales = monthlySales.get(i);
                monthWithMaxSales = i + 1;
            }
        }

        return monthWithMaxSales;
    }
}