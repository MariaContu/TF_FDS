package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.model.Produto;

@Repository
public class RepProdutosMem implements IRepProdutos{

    private List<Produto> prods;

    public RepProdutosMem(){
        prods = new LinkedList<>();
        prods.add(new Produto(10,"banana",3.5));
        prods.add(new Produto(20,"maca",5.0));
    }

    @Override
    public void save(Produto p) {
        prods.add(p);
    }

    @Override
    public List<Produto> all() {
        return prods;
    }
    
}
