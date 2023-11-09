package com.example.sistemaVendas.Dominio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    private int itemQuant;

    public ItemPedido(){}

    public ItemPedido(long id, int quant){
        itemId=id;
        itemQuant=quant;
    }

    public long getItemId() {
        return itemId;
    }
    
    public int getItemQuant() {
        return itemQuant;
    }

    public void setItemQuant(int quant) {
        itemQuant=quant;
    }
}
