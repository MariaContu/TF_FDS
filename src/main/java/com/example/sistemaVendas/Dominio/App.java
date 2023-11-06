package com.example.sistemaVendas.Dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Orcamento> orcamentos = new ArrayList<>();

        Produto prod1 = new Produto(1, "pao", 2);
        Produto prod2 = new Produto(2, "queijo", 9);
        Produto prod3 = new Produto(3, "presunto",6);
        Produto prod4 = new Produto(4, "carne", 25);
        Produto prod5 = new Produto(5, "frango", 10);
        Produto prod6 = new Produto(6, "bacon", 20);

        Estoque estoque = Estoque.getInstance();

        estoque.addProduto(prod1, 50);
        estoque.addProduto(prod2, 26);
        estoque.addProduto(prod3, 14);
        estoque.addProduto(prod4, 70);
        estoque.addProduto(prod5, 90);
        estoque.addProduto(prod6, 55);

        System.out.println("Estoque:\n\n");
        System.out.println(estoque.relatorio());



        Pedido p1 = new Pedido(1, "Jeff");
        p1.addItem(1, 10);
        p1.addItem(5,4);
        
        Orcamento o1 = new Orcamento(1, "Jeff", LocalDateTime.now());
        o1.adicionarPedidos(p1);
        orcamentos.add(o1);

        Pedido p2 = new Pedido(2, "Isa");
        p2.addItem(4, 9);
        p2.addItem(2,6);

        Orcamento o2 = new Orcamento(2, "Isa", LocalDateTime.now(), p);
        orcamentos.add(o2);

        Pedido p3 = new Pedido(3, "Leo");
        p3.addItem(6, 1);
        p3.addItem(5,5);

        Orcamento o3 = new Orcamento(3, "Leo", LocalDateTime.now(), p3);
        orcamentos.add(o3);

        Pedido p4 = new Pedido(4, "Alex");
        p4.addItem(3, 4);
        p4.addItem(4,3);

        Orcamento o4 = new Orcamento(4, "Alex", LocalDateTime.now(), p4);
        orcamentos.add(o4);

        Pedido p5 = new Pedido(5, "Fred");
        p5.addItem(1, 7);
        p5.addItem(4,6);

        Orcamento o5 = new Orcamento(5, "Fred", LocalDateTime.now(), p5);
        orcamentos.add(o5);

        Pedido p6 = new Pedido(6, "Luis");
        p6.addItem(1, 8);
        p6.addItem(6,8);
        
        Orcamento o6 = new Orcamento(6, "Luis", LocalDateTime.now(), p6);
        orcamentos.add(o6);

        Pedido p7 = new Pedido(7, "Maria");
        p7.addItem(2, 10);
        p7.addItem(5,11);

        Orcamento o7 = new Orcamento(7, "Maria", LocalDateTime.now(), p7);
        orcamentos.add(o7);

        Pedido p8 = new Pedido(8, "Dudu");
        p8.addItem(3, 5);
        p8.addItem(5,3);

        Orcamento o8 = new Orcamento(8, "Dudu", LocalDateTime.now(), p8);
        orcamentos.add(o8);

        System.out.println("Pedidos:\n\n");

        if(p1.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p1.getProdutosPedido().values()) {
                estoque.retira(prod, p1.getQtdPedido(prod)); 
            }
            System.out.println(p1.toString()+" "+o1.toString());
        }

        if(p2.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p2.getProdutosPedido().values()) {
                estoque.retira(prod, p2.getQtdPedido(prod)); 
            }
            System.out.println(p2.toString()+" "+o2.toString());
        }

        if(p3.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p3.getProdutosPedido().values()) {
                estoque.retira(prod, p3.getQtdPedido(prod)); 
            }
            System.out.println(p3.toString()+" "+o3.toString());
        }

        if(p4.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p4.getProdutosPedido().values()) {
                estoque.retira(prod, p4.getQtdPedido(prod)); 
            }
            System.out.println(p4.toString()+" "+o4.toString());
        }

        if(p5.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p5.getProdutosPedido().values()) {
                estoque.retira(prod, p5.getQtdPedido(prod)); 
            }
            System.out.println(p5.toString()+" "+o5.toString());
        }

        if(p6.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p6.getProdutosPedido().values()) {
                estoque.retira(prod, p6.getQtdPedido(prod)); 
            }
            System.out.println(p6.toString()+" "+o6.toString());
        }

        if(p7.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p7.getProdutosPedido().values()) {
                estoque.retira(prod, p7.getQtdPedido(prod)); 
            }
            System.out.println(p7.toString()+" "+o7.toString());
        }

        if(p8.verificaViab() == true){
            System.out.println("Estoque Efetivado\n");
            for (Produto prod : p8.getProdutosPedido().values()) {
                estoque.retira(prod, p8.getQtdPedido(prod)); 
            }
            System.out.println(p8.toString()+" "+o8.toString());
        }

        System.out.println("Estoque:\n\n");
        System.out.println(estoque.relatorio());
    }
}
