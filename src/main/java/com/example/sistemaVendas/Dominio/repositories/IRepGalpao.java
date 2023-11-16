package com.example.sistemaVendas.Dominio.repositories;

import java.util.List;

<<<<<<< HEAD
import com.example.sistemaVendas.Dominio.model.ItemEstoque;

public interface IRepGalpao {

    List<ItemEstoque> listAllProdutos();
    ItemEstoque findById(long id);

=======
import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.Produto;

public interface IRepGalpao {

    List<Produto> listAllProdutos();
    Produto findById(long id);
    
    void addGalpao(Galpao galpao);
    
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
}