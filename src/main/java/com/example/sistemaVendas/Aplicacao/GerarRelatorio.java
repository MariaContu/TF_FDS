package com.example.sistemaVendas.Aplicacao;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Aplicacao.services.ServicoRelatorio;
import com.example.sistemaVendas.Persistencias.repositories.RepClienteORM;
import com.example.sistemaVendas.Persistencias.repositories.RepOrcamentosORM;
import com.example.sistemaVendas.Persistencias.repositories.RepProdutosORM;

public class GerarRelatorio {
    public static void main(String[] args) {
        RepClienteORM repCliente =  new RepClienteORM();
        RepOrcamentosORM repOrcamentos = new RepOrcamentosORM();
        RepProdutosORM repProdutos = new RepProdutosORM();

        ServicoRelatorio servicoRelatorio = new ServicoRelatorio(repCliente, repOrcamentos, repProdutos);

        // Geração de relatórios
        Relatorio relatorioVendasPorProduto = servicoRelatorio.analiseVendasPorProduto();
        Relatorio relatorioDesempenhoCliente = servicoRelatorio.analiseDesempenhoCliente();

        // Exemplo de exibição dos relatórios
        System.out.println("Relatório de Vendas por Produto:\n" + relatorioVendasPorProduto);
        System.out.println("Relatório de Desempenho do Cliente:\n" + relatorioDesempenhoCliente);
    }
}
