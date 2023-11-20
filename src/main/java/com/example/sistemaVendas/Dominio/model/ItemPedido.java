package com.example.sistemaVendas.Dominio.model;

import javax.persistence.Entity;
@Entity
public class ItemPedido {

    private long itemId;

    private int itemQuant;

    public ItemPedido(long itemId, int quant){
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
