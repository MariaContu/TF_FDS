package com.example.sistemaVendas.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Aplicacao.services.ServicoRelatorio;

@Component
public class GerarRelatorio {
    @Autowired
    private ServicoRelatorio servicoRelatorio;

    public Relatorio relatorioMediaValorFinalTodosOrcamentos() {
        Relatorio r = new Relatorio();

        r.adicionarSecao("Relatório de média do valor final de todos os orçamentos efetivados:");
        r.getSecoes().addAll(servicoRelatorio.calculaMediaValorFinalTodosOrcamentos().getSecoes());

        return r;
    }

    public Relatorio relatorioMediaComprasUltimosSeisMesesClientes() {
        Relatorio r = new Relatorio();

        r.adicionarSecao("Relatório de média de compras nos últimos seis meses de todos os clientes:");
        r.getSecoes().addAll(servicoRelatorio.calculaMediaComprasUltimosSeisMesesClientes().getSecoes());

        return r;
        
    }

    public Relatorio relatorioMediaQuantidadeItensPorCompra() {
        Relatorio r = new Relatorio();

        r.adicionarSecao("Relatório de média de itens por orçamento efetivado:");
        r.getSecoes().addAll(servicoRelatorio.calculaMediaQuantidadeItensPorCompra().getSecoes());

        return r;
        
    }
}