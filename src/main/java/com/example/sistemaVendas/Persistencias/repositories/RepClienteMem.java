package com.example.sistemaVendas.Persistencias.repositories;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Orcamento;

@Repository
public class RepClienteMem implements IRepCliente{

    private List<Cliente> clis;

    public RepClienteMem(){
        clis = new LinkedList<>();
        clis.add(new Cliente(1,"Ana", 55000, 12));
        clis.add(new Cliente(2,"Joaquim", 11000, 8));
        clis.add(new Cliente(3,"Fernanda", 0, 0));
        clis.add(new Cliente(4,"Augusto", 0, 0));
        clis.add(new Cliente(5,"Joao", 0, 0));
        clis.add(new Cliente(6,"Amanda", 0, 0));
        clis.add(new Cliente(7,"Yasmin", 0, 0));
        clis.add(new Cliente(8,"Alysson", 0, 0));
        clis.add(new Cliente(9,"Gustavo", 0, 0));
        clis.add(new Cliente(10,"Joana", 0, 0));
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
    public void calculaValorMedio(Cliente cliente) {
        if (!cliente.getOrcamentos().isEmpty() && cliente.getOrcamentos().size()>=3) {
            List<Orcamento> ultimos3pedidos = cliente.getOrcamentos().subList(cliente.getOrcamentos().size() -3, cliente.getOrcamentos().size());
        
            double soma=0;
            for (Orcamento p : ultimos3pedidos) {
                soma+=p.getValorFinal();
            }

            cliente.setValorMedio(soma/3);
        }
        else {
            if (cliente.getOrcamentos().isEmpty()) {
                cliente.setValorMedio(0);
            }
            else    {
                double soma=0;
                for (Orcamento o : cliente.getOrcamentos()) {
                    soma+=o.getValorFinal();
                }
                cliente.setValorMedio(soma/cliente.getOrcamentos().size());
            }
        }
    }

    @Override
    public double calculaDescontoUltimosSeisMeses(Cliente cliente) {
        if (cliente.getComprasUltimosSeisMeses()>10) {
            return 0.25;
        }
        return 0;
    }

    @Override
    public double descontoDeCliente(Cliente cliente) {
        double descontoUltimosMeses= calculaDescontoUltimosSeisMeses(cliente);
        double descontoValorMedio=0;

        if (cliente.getValorMedio()>10000) {
            descontoValorMedio=0.1;
        }
        double valorAMais = cliente.getValorMedio()-10000;
        descontoValorMedio += 0.05 * (int)(valorAMais / 10000);

        // Limita o desconto a 30%
        descontoValorMedio = Math.min(descontoValorMedio, 0.3);

        double maiorDesconto=Math.max(descontoValorMedio, descontoUltimosMeses);

        return (1-maiorDesconto);
    }

    @Override
    public void addPedido(Cliente cliente, Orcamento orcamento) {
        List<Orcamento> listOrcs = new LinkedList<>();
        cliente.setOrcamentos(listOrcs);
        cliente.getOrcamentos().add(orcamento);
    }

    @Override
    public void atualizaValorMedio(Cliente cliente) {
        calculaValorMedio(cliente); //setta o valor medio do cliente aualizado
    }

    @Override
    public void atualizaComprasUltimosMeses(Cliente cliente) {
        Calendar seisMesesAtras = Calendar.getInstance();
        seisMesesAtras.add(Calendar.MONTH, -6);

        int count=0;

        for (Orcamento o : cliente.getOrcamentos()) {
            if (o.getData().after(seisMesesAtras.getTime())) {
                count++;
            }
        }
        cliente.setComprasUltimosSeisMeses(count);
    }

    @Override
    public Cliente findById(long id) {
        for (Cliente cli : clis) {
            if(cli.getId() == id){
                return cli;
            }
        }
        return null;
    }
    
}
