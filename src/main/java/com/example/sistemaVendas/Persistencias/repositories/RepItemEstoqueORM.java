package com.example.sistemaVendas.Persistencias.repositories;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;

@Repository
<<<<<<< HEAD
public class RepItemEstoqueORM implements IRepItemEstoque {
    private List<ItemEstoque> itens;

    public RepItemEstoqueORM() {
        itens = new ArrayList<>();
    }

    @Override
    public List<ItemEstoque> allItemEstoque() {
        return new ArrayList<>(itens);
    }

    @Override
    public ItemEstoque findItemEstoqueByProdutoID(long codigoProduto) {
        return itens.stream()
                .filter(item -> codigoProduto == item.getCodigoProduto())
                .findFirst()
                .orElse(null);
=======
public class RepItemEstoqueORM implements IRepItemEstoque{

    @Override
    public List<ItemEstoque> allItemEstoque() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allItemEstoque'");
    }

    @Override
    public ItemEstoque findItemEstoqueByProdutoID(long itemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findItemEstoqueByProdutoID'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public void addItemEstoque(ItemEstoque itemEstoque) {
<<<<<<< HEAD
        if (itemEstoque != null) {
            itens.add(itemEstoque);
        }
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItemEstoque'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public void attQuantItemEstoque(ItemEstoque itemEstoque, int novaQuant) {
<<<<<<< HEAD
        if (itemEstoque != null) {
            ItemEstoque encontrado = findItemEstoqueByProdutoID(itemEstoque.getCodigoProduto());
            if (encontrado != null) {
                encontrado.setQuantAtual(novaQuant);
            }
        }
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attQuantItemEstoque'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public void removeItemEstoque(ItemEstoque itemEstoque) {
<<<<<<< HEAD
        itens.removeIf(item -> item != null && item.getCodigoProduto() == itemEstoque.getCodigoProduto());
    }

}
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItemEstoque'");
    }
    
}
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
