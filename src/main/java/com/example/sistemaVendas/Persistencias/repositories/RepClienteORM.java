package com.example.sistemaVendas.Persistencias.repositories;

<<<<<<< HEAD
import java.util.LinkedList;
=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.Cliente;
<<<<<<< HEAD
import com.example.sistemaVendas.Dominio.model.Orcamento;
=======
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;

@Repository
public class RepClienteORM implements IRepCliente{
<<<<<<< HEAD
    public List<Cliente> clientes;

    public RepClienteORM()  {
        clientes = new LinkedList<>();
        clientes.add(new Cliente(1,"Ana", 0, 0));
        clientes.add(new Cliente(2,"Joaquim", 0, 0));
        clientes.add(new Cliente(3,"Fernanda", 0, 0));
        clientes.add(new Cliente(4,"Augusto", 0, 0));
        clientes.add(new Cliente(5,"Joao", 0, 0));
        clientes.add(new Cliente(6,"Amanda", 0, 0));
        clientes.add(new Cliente(7,"Yasmin", 0, 0));
        clientes.add(new Cliente(8,"Lucas", 0, 0));
    }

    @Override
    public Cliente findByName(String name) {
        for (Cliente c : clientes) {
            if (name.toUpperCase().equals(c.getName().toUpperCase())) {
                return c;
            }
        }
        return null;
=======

    @Override
    public Cliente findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }

    @Override
    public List<Cliente> allClientes() {
<<<<<<< HEAD
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
            double soma=0;
            for (Orcamento o : cliente.getOrcamentos()) {
                soma+=o.getValorFinal();
            }
            cliente.setValorMedio(soma/3);
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

        return maiorDesconto;
=======
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'allClientes'");
    }

    @Override
    public void attValorMedio(Cliente cliente, double valorNovo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attValorMedio'");
    }

    @Override
    public void attComprasSeisMeses(Cliente cliente, int countMeses) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attComprasSeisMeses'");
>>>>>>> c1495eaf9b6ff7cc7ab4f1bcb470ca4945e7f046
    }
    
}
