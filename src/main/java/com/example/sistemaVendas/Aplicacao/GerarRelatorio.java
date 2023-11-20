package com.example.sistemaVendas.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Aplicacao.services.ServicoRelatorio;

@Component
public class GerarRelatorio {
    @Autowired
    private ServicoRelatorio servicoRelatorio;

    public Relatorio gerarRelatorio() {
        Relatorio relatorio = new Relatorio();

        // Adicione o relatório de desempenho do cliente
        relatorio.adicionarSecao("Relatório de Desempenho do Cliente:");
        relatorio.getSecoes().addAll(servicoRelatorio.analiseDesempenhoCliente().getSecoes());

        // Adicione o relatório de vendas por produto
        relatorio.adicionarSecao("\nRelatório de Vendas por Produto:");
        relatorio.getSecoes().addAll(servicoRelatorio.analiseVendasPorProduto().getSecoes());

        relatorio.adicionarSecao("\nRelatório do Custo Médio dos Orçamentos");
        relatorio.adicionarConteudo(servicoRelatorio.calculaCustoMedioOrcamentos());

        return relatorio;
    }
}