package com.example.sistemaVendas.Dominio.model;

public class ItemPedido {

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