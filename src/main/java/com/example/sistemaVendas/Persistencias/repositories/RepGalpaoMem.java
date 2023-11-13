package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.model.Produto;

@Repository
public class RepGalpaoMem implements IRepGalpao{

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
    
}
