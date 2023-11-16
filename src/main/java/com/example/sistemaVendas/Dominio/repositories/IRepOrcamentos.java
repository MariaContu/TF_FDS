package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Orcamento;


public interface IRepOrcamentos {
    void addOrcamento(Orcamento o);
    List<Orcamento> all();
    
    void attEfetivado(Orcamento orcamento, boolean efetivado);
    void attValido(Orcamento orcamento, boolean valido);

    boolean verificaValidade(Orcamento orcamento);

    void calculaCustoPedido(Orcamento orcamento);
    void calculaValorFinal(Orcamento orcamento);
    boolean verificaDisponibilidadeItens(Orcamento orcamento);
}
