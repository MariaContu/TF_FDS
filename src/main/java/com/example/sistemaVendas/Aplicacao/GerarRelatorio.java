package com.example.sistemaVendas.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Aplicacao.services.ServicoRelatorio;

@Component
public class GerarRelatorio {
    @Autowired
    private ServicoRelatorio servicoRelatorio;

    public Relatorio gerarTodosRelatorios() {
        Relatorio relatorio = new Relatorio();

        // Adicione o relatório de desempenho do cliente
        relatorio.adicionarConteudo("Relatório de Desempenho do Cliente:\n");
        relatorio.adicionarConteudo(servicoRelatorio.analiseDesempenhoCliente().getConteudo());

        // Adicione o relatório de vendas por produto
        relatorio.adicionarConteudo("\nRelatório de Vendas por Produto:\n");
        relatorio.adicionarConteudo(servicoRelatorio.analiseVendasPorProduto().getConteudo());

        relatorio.adicionarConteudo("\nRelatório do Custo Medio dos Orçamantos");
        relatorio.adicionarConteudo(servicoRelatorio.calculaCustoMedioOrcamentos());

        return relatorio;
    }

    public Relatorio relatorioDesempenhoDoCliente() {
        Relatorio relatorio = new Relatorio();

        // Adicione o relatório de desempenho do cliente
        relatorio.adicionarConteudo("Relatório de Desempenho do Cliente:\n");
        relatorio.adicionarConteudo(servicoRelatorio.analiseDesempenhoCliente().getConteudo());

        return relatorio;
    }

    public Relatorio relatorioVendasPorProduto() {
        Relatorio relatorio = new Relatorio();

        // Adicione o relatório de vendas por produto
        relatorio.adicionarConteudo("\nRelatório de Vendas por Produto:\n");
        relatorio.adicionarConteudo(servicoRelatorio.analiseVendasPorProduto().getConteudo());

        return relatorio;
    }

    public Relatorio relatorioCustoMedioOrcamentos() {
        Relatorio relatorio = new Relatorio();

        relatorio.adicionarConteudo("\nRelatório do Custo Medio dos Orçamantos");
        relatorio.adicionarConteudo(servicoRelatorio.calculaCustoMedioOrcamentos());

        return relatorio;
    }

}
