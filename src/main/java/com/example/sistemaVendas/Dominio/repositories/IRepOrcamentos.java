package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Orcamento;


public interface IRepOrcamentos {
 
    List<Orcamento> all();
    
    void attEfetivado(Orcamento orcamento);
    void attValido(Orcamento orcamento);

    boolean verificaValidade(Orcamento orcamento);
    
}
