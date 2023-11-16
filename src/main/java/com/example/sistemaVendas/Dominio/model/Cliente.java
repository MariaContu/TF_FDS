package com.example.sistemaVendas.Dominio.model;

<<<<<<< HEAD
import java.util.LinkedList;
import java.util.List;
=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046

public class Cliente {

    private long id;
<<<<<<< HEAD
    private String name;
    private List<Orcamento> orcamentos;
=======

    private String name;
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    private double valorMedio;
    private int comprasUltimosSeisMeses;
    
    public Cliente(){}

    public Cliente(long id, String name, double valorMedio, int comprasUltimosSeisMeses){
        this.id=id;
        this.name=name;
<<<<<<< HEAD
        orcamentos=new LinkedList<>();
=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
        this.valorMedio=valorMedio;
        this.comprasUltimosSeisMeses=comprasUltimosSeisMeses;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD
    public List<Orcamento> getOrcamentos() {
        return orcamentos;
    }

=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    public double getValorMedio() {
        return valorMedio;
    }

    public int getComprasUltimosSeisMeses() {
        return comprasUltimosSeisMeses;
    }

    public void setValorMedio(double valorMedio) {
        this.valorMedio = valorMedio;
    }

    public void setComprasUltimosSeisMeses(int comprasUltimosSeisMeses) {
        this.comprasUltimosSeisMeses = comprasUltimosSeisMeses;
    }
<<<<<<< HEAD

    public void setOrcamentos(List<Orcamento> orcamentos)    {
        this.orcamentos=orcamentos;
    }

=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
}