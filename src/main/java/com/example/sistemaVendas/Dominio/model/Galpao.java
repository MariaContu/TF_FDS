package com.example.sistemaVendas.Dominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Galpao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idItem;
    private int quantItem;

    public long getId() {
        return id;
    }

    public long getIdItem() {
        return idItem;
    }

    public int getQuantItem() {
        return quantItem;
    }
    
}
