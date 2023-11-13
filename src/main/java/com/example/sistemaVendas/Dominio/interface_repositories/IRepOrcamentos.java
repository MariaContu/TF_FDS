package com.example.sistemaVendas.Dominio.interface_repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Orcamento;

public interface IRepOrcamentos {
    List<Orcamento> listarOrcamentos();

    Orcamento obterOrcamentosPorId(long orcId);

    void adicionarOr(Orcamento orcamento);

    void atualizarItemEstoque(Orcamento orcamento);

    void removerOrcamento(long orcId);
}
