package com.example.sistemaVendas.Dominio.interface_repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;

public interface IRepOrcamentos {
    List<Orcamento> listarOrcamentos();

    Orcamento obterOrcamentosPorId(long orcId);

    void adicionarOr(Orcamento orcamento);
    
    void attEfetivado(Orcamento orcamento, boolean efetivado);
    void attValido(Orcamento orcamento, boolean valido);

    boolean verificaValidade(Orcamento orcamento);

    void calculaCustoPedido(Orcamento orcamento);
    void calculaValorFinal(Orcamento orcamento);
    boolean verificaDisponibilidadeItens(List<ItemPedido> itensPedido);
}
