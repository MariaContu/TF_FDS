package com.example.sistemaVendas.Persistencias.repositories;

<<<<<<< HEAD
import java.util.LinkedList;
=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
import java.util.List;

import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
=======
import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.Produto;
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
import com.example.sistemaVendas.Dominio.repositories.IRepGalpao;

@Repository
public class RepGalpaoORM implements IRepGalpao {
<<<<<<< HEAD
    private List<ItemEstoque> itens;

    public RepGalpaoORM()  {
        itens = new LinkedList<>();
    }

    @Override
    public List<ItemEstoque> listAllProdutos() {
        return itens;
    }

    @Override
    public ItemEstoque findById(long id) {
        for (ItemEstoque i : itens) {
            if (id==i.getCodigoProduto()) {
                return i;
            }
        }
        return null;
    }
=======

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
    
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
}
