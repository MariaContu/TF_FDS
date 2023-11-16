package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;

@Repository
public class RepProdutosORM implements IRepProdutos {

    private List<Produto> produtos;


    public RepProdutosORM(){
        produtos=new LinkedList<>();
        produtos.add(new Produto(1,"Café Espresso", 3.50));
        produtos.add(new Produto(2,"Cappuccino com Nutella", 7.00));
        produtos.add(new Produto(3,"Affogato - Sorvete de Baunilha com Espresso", 10.00));
        produtos.add(new Produto(4, "Latte Macchiato", 8.50));
        produtos.add(new Produto(5, "Mocha com Chocolate", 9.00));
        produtos.add(new Produto(6, "Café Passado - Americano", 4.00));
        produtos.add(new Produto(7, "4 Brigadeiros", 8.00));
        produtos.add(new Produto(8, "Tiramissu", 10.00));
        produtos.add(new Produto(9, "Bolo de Cenoura com Chocolate", 6.50));
        produtos.add(new Produto(10, "Cupcake de Baunilha com Brigadeiro", 5.00));
    }


    @Override
    public void save(Produto p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Produto> all() {
        return produtos;
    }

    @Override
    public Produto findById(long id) {
        for (Produto produto : produtos) {
            if (id==produto.getCodigo()) {
                return produto;
            }
        }
        return null;
    }
}
