package com.example.sistemaVendas.Dominio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ItemPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    private int itemQuant;

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
