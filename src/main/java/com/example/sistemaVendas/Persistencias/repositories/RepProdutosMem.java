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
        prods.add(new Produto(1,"Placa-mae", 730.50));
        prods.add(new Produto(2,"Placa de video", 1900.00));
        prods.add(new Produto(3,"Water cooler", 500.00));
        prods.add(new Produto(4, "Fonte 750w", 480.50));
        prods.add(new Produto(5, "Memória RAM 16gb (2x8gb)", 335.00));
        prods.add(new Produto(6, "Processador", 1400.00));
        prods.add(new Produto(7, "SSD 500gb", 350.00));
        prods.add(new Produto(8, "M.2 1TB", 400.80));
        prods.add(new Produto(9, "Monitor 144hz", 920.50));
        prods.add(new Produto(10, "Teclado Mecanico", 250.0));
        prods.add(new Produto(11, "Mouse sem fio",650.50));
    }

    @Override
    public void save(Produto p) {
        prods.add(p);
    }

    @Override
    public List<Produto> all() {
        return prods;
    }

    @Override
    public Produto findById(long id) {
        for (Produto prod : prods) {
            if(prod.getCodigo() == id){
                return prod;
            }
        }
        return null;
    }
    
}
