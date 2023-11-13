package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.model.Orcamento;

@Repository
public class RepOrcamentosMem implements IRepOrcamentos{

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
