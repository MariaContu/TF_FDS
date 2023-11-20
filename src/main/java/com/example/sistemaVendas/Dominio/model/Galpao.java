package com.example.sistemaVendas.Dominio.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Galpao {
    private long id;

    public Galpao(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public List<ItemEstoque> galpao(){
        return new LinkedList<>();
    }
    
}
