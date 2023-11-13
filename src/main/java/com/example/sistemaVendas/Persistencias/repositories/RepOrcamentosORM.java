package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;

public class RepOrcamentosORM implements IRepOrcamentos{

    @Override
    public List<Orcamento> listarOrcamentos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarOrcamentos'");
    }

    @Override
    public Orcamento obterOrcamentosPorId(long orcId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterOrcamentosPorId'");
    }

    @Override
    public void adicionarOr(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarOr'");
    }

    @Override
    public void atualizarItemEstoque(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarItemEstoque'");
    }

    @Override
    public void removerOrcamento(long orcId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerOrcamento'");
    }
    
}
