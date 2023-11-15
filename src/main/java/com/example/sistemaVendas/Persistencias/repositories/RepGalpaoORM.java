package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepGalpao;

@Repository
public class RepGalpaoORM implements IRepGalpao {

    @Override
    public List<Produto> listAllProdutos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllProdutos'");
    }

    @Override
    public Produto findById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void addGalpao(Galpao galpao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addGalpao'");
    }
    
}
