package com.example.sistemaVendas.Persistencias.repositories;

import java.util.List;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;

public class RepProdutosORM implements IRepProdutos{

    @Override
    public void save(Produto p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Produto> all() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'all'");
    }
    
}
