package com.example.sistemaVendas.Dominio;

import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private Map<Integer,Integer> pedido;
    private Map<Produto,Integer> estoque = Estoque.getEstoque();
    private Map<Integer,Produto> p;

    private int id;
    private String name;

    public Pedido(int id, String cliente){
        pedido = new HashMap<>();
        p = new HashMap<>();
        this.id = id;
        name = cliente;
        
    }

    public Map<Integer,Produto> getProdutosPedido(){
        return p;
    }

    public Map<Integer,Integer> getItens(){
        return pedido;
    }

    public void addItem(int id_produto, int qntdDesejada){
        pedido.put(id_produto, qntdDesejada);
        for(int i : pedido.keySet()){//a melhorar
                for (Produto prod : estoque.keySet()) {
                    if(prod.getId() == i){
                        p.put(i, prod);
                    }
                }
        }
    }

    public int getQtdPedido(Produto produto){
        return pedido.get(produto.getId());
    }

    public boolean verificaViab(){
        for (int id : getItens().keySet()) {
            int qtdEstoque = estoque.get(getProdutosPedido().get(id));
            int qtdDesejada = getItens().get(id); 
            if(qtdDesejada > qtdEstoque || qtdEstoque-qtdDesejada < Estoque.getQtdMin()) {
                return false;
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder s = new StringBuilder("");

        s.append("Pedido "+id+": Cliente - "+name);
        s.append("\n");
        for (int id: pedido.keySet()) {
            s.append(p.get(id).toString()+ " Qtd pedido: "+pedido.get(id));
            s.append("\n");
        }
        
        return s.toString();
    }


}
