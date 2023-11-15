package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;

@Repository
public class RepOrcamentosORM implements IRepOrcamentos{

    @Override
    public List<Orcamento> all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'all'");
    }

    @Override
    public void attEfetivado(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attEfetivado'");
    }

    @Override
    public void attValido(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attValido'");
    }

    @Override
    public boolean verificaValidade(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaValidade'");
    }
    
}
