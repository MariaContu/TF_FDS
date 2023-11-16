package com.example.sistemaVendas.Persistencias.repositories;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;

@Repository
<<<<<<< HEAD
public class RepOrcamentosORM implements IRepOrcamentos {

    private List<Orcamento> orcamentos;

    public RepOrcamentosORM() {
        orcamentos = new ArrayList<>();
    }

    @Override
    public List<Orcamento> all() {
        return new ArrayList<>(orcamentos);
=======
public class RepOrcamentosORM implements IRepOrcamentos{

    @Override
    public List<Orcamento> all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'all'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public void attEfetivado(Orcamento orcamento) {
<<<<<<< HEAD
        Orcamento encontrado = findOrcamentoById(orcamento.getId());
        if (encontrado != null) {
            encontrado.setEfetivado(true);
        }
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attEfetivado'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public void attValido(Orcamento orcamento) {
<<<<<<< HEAD
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
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attValido'");
    }
    
}
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
