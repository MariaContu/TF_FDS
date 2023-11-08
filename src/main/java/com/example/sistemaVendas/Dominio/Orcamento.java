package com.example.sistemaVendas.Dominio;

import java.time.LocalDateTime;
import java.util.Map;

import com.example.sistemaVendas.Dominio.entidades.Pedido;
import com.example.sistemaVendas.Dominio.entidades.Produto;

public class Orcamento {
    private int id;
    private double sumPrecos;
    private final double imposto = 0.10;
    private final double desconto = 0.05;
    private double valFinal;
    private Map<Integer,Produto> produtos;
    private Map<Integer,Integer> itens_pedido;
    private Map<Integer,Map<Integer,Integer>> todos_pedidos;
    private int count = 0;

    public Orcamento(int id, String name, LocalDateTime data){
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public double orcamento(Map<Integer,Integer> itens_pedido){
        for (int id_produto : itens_pedido.keySet()) {
            sumPrecos += (produtos.get(id_produto).getPreco()*itens_pedido.size());
        }
        valFinal = sumPrecos+(sumPrecos*imposto);
        if(itens_pedido.size() >= 5){
            valFinal = sumPrecos-(sumPrecos*desconto);
        }
        return valFinal;
    }

    public void adicionarPedidos(Pedido p){
        if(!produtos.isEmpty()){
            produtos.putAll(p.getProdutosPedido());
        }else{
            produtos = p.getProdutosPedido();
        }
        itens_pedido = p.getItens();
        todos_pedidos.put(count++,itens_pedido);
    }

    public String toString(){
        return "Custo Total: "+valFinal;
    }
}
