package com.example.sistemaVendas.Dominio;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private static Estoque estoque;
    private static int qtdMax;
    private static int qtdMin;
    private static Map<Produto, Integer> mapQtd = new HashMap<>();


    public Estoque(int qtdMax, int qtdMin){
        Estoque.qtdMax = qtdMax;
        Estoque.qtdMin = qtdMin;
    }
    
    public static Estoque getInstance() {
        if (estoque == null) {
            estoque = new Estoque(100,10);
        }
        return estoque;
    }

    public void addProduto(Produto produto, int qtd) {
            if(qtd > qtdMax || qtd < qtdMin){
                System.out.println("Quantidade Invalida: " + qtd);
            }else{
                mapQtd.put(produto, qtd);
            }    
    }

    public void setQtd(Produto produto, int qtd) {
        qtd = mapQtd.get(produto)-qtd;
        mapQtd.replace(produto, mapQtd.get(produto), qtd);
    }

    public int getQtdAtual(Produto produto) {
        return mapQtd.get(produto);
    }

    public void retira(Produto p, int qtd){     
        setQtd(p, qtd);
    }

    public static Map<Produto,Integer> getEstoque(){
        return mapQtd;
    }

    public static int getQtdMax(){
        return qtdMax;
    }

    public static int getQtdMin(){
        return qtdMin;
    }

    public String relatorio() {
        StringBuilder rel = new StringBuilder("");
        for (Produto pr : mapQtd.keySet()) {
            rel.append(pr.toString());
            rel.append(" Qtd: "+ mapQtd.get(pr));
            rel.append("\n");
        }
        return rel.toString();
    }

}
