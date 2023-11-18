package com.example.sistemaVendas.Aplicacao;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Aplicacao.services.ServicoRelatorio;

public class GerarRelatorio {
    @Autowired
    private ServicoRelatorio servicoRelatorio;

    public Relatorio gerarRelatorio() {
        Relatorio r = new Relatorio();
        r = servicoRelatorio.analiseDesempenhoCliente();
        r = servicoRelatorio.analiseVendasPorProduto();
        return r;
    }
}
