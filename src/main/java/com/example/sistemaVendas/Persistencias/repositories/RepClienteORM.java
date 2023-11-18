package com.example.sistemaVendas.Persistencias.repositories;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;

@Repository
public class RepClienteORM implements IRepCliente{
    private List<Cliente> clientes;

    public RepClienteORM()  {
        clientes = new LinkedList<>();
        clientes.add(new Cliente(1,"Ana", 55000, 12));
        clientes.add(new Cliente(2,"Joaquim", 0, 0));
        clientes.add(new Cliente(3,"Fernanda", 0, 0));
        clientes.add(new Cliente(4,"Augusto", 0, 0));
        clientes.add(new Cliente(5,"Joao", 0, 0));
        clientes.add(new Cliente(6,"Amanda", 0, 0));
        clientes.add(new Cliente(7,"Yasmin", 0, 0));
        clientes.add(new Cliente(8,"Alysson", 0, 0));
        clientes.add(new Cliente(9,"Gustavo", 0, 0));
        clientes.add(new Cliente(10,"Joana", 0, 0));
    }

    @Override
    public Cliente findByName(String name) {
        for (Cliente c : clientes) {
            if (name.toUpperCase().equals(c.getName().toUpperCase())) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> allClientes() {
        return clientes;
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
        List<Orcamento> listaOrcamentos;
        listaOrcamentos = cliente.getOrcamentos();
        listaOrcamentos.add(orcamento);
        cliente.setOrcamentos(listaOrcamentos);
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
}
