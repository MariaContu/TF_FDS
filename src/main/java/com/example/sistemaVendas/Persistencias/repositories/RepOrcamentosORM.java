package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;

@Repository
public class RepOrcamentosORM implements IRepOrcamentos{
    private List<Orcamento> orcamentos;

    public RepOrcamentosORM(){
        orcamentos = new LinkedList<>();
    }

    @Override
    public List<Orcamento> all() {
        return orcamentos;
    }
    
    @Override
    public void addOrcamento(Orcamento o) {
        orcamentos.add(o);
    }
    
    @Override
    public void attEfetivado(Orcamento orcamento, boolean efetivado) {
        orcamento.setEfetivado(efetivado);
    }

    @Override
    public void attValido(Orcamento orcamento, boolean valido) {
        orcamento.setValido(valido);
    }

    @Override
    public boolean verificaValidade(Orcamento orcamento) {
        if (orcamento.getNomeCliente() != null && orcamento.getPedido() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void calculaValorFinal(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculaValorFinal'");
    } 
}
