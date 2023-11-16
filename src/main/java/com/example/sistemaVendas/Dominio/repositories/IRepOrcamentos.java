package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Orcamento;


public interface IRepOrcamentos {
 
    List<Orcamento> all();
<<<<<<< HEAD

    Orcamento findOrcamentoById(long id);

    void attEfetivado(Orcamento orcamento);
    void attValido(Orcamento orcamento);

    boolean verificaValidade(Orcamento orcamento);
=======
    
    void attEfetivado(Orcamento orcamento);
    void attValido(Orcamento orcamento);
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    
}
