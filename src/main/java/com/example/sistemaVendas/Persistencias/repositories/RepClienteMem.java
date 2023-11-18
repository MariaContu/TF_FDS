package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.model.Cliente;

public class RepClienteMem implements IRepCliente{

    private List<Cliente> clis;

    public RepClienteMem(){
        clis = new LinkedList<>();
        clis.add(new Cliente(1, "Lucas", 0, 0));
        clis.add(new Cliente(2, "Contu", 0, 0));
        clis.add(new Cliente(3, "Linus", 0, 0));
    }
    
    @Override
    public Cliente findByName(String name) {
        for (Cliente cli : clis) {
            if(cli.getName().equals(name)){
                return cli;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> allClientes() {
        return clis;
    }

    @Override
    public void attValorMedio(Cliente cliente, double valorNovo) {
        cliente.setValorMedio(valorNovo);
    }

    @Override
    public void attComprasSeisMeses(Cliente cliente, int countMeses) {
        cliente.setComprasUltimosSeisMeses(countMeses);
    }
    
}
