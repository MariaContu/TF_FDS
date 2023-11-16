package com.example.sistemaVendas.Persistencias.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;

@Repository
public class RepOrcamentosORM implements IRepOrcamentos {

    private List<Orcamento> orcamentos;

    public RepOrcamentosORM() {
        orcamentos = new ArrayList<>();
    }

    @Override
    public List<Orcamento> all() {
        return new ArrayList<>(orcamentos);
    }

    @Override
    public void attEfetivado(Orcamento orcamento) {
        Orcamento encontrado = findOrcamentoById(orcamento.getId());
        if (encontrado != null) {
            encontrado.setEfetivado(true);
        }
    }

    @Override
    public void attValido(Orcamento orcamento) {
        Orcamento encontrado = findOrcamentoById(orcamento.getId());
        if (encontrado != null) {
            encontrado.setValido(true);
        }
    }

    @Override
    public boolean verificaValidade(Orcamento orcamento) {
        Orcamento encontrado = findOrcamentoById(orcamento.getId());
        return encontrado != null && encontrado.getValido();
    }

    // Método auxiliar para encontrar um Orcamento pelo ID
    public Orcamento findOrcamentoById(long id) {
        return orcamentos.stream()
                .filter(o -> id == o.getId())
                .findFirst()
                .orElse(null);
    }
}
