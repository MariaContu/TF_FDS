package com.example.sistemaVendas.Dominio.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Galpao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
