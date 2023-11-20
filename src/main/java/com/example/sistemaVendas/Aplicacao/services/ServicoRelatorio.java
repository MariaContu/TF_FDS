package com.example.sistemaVendas.Aplicacao.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.model.Orcamento;

@Service
public class ServicoRelatorio {
    private IRepCliente repCliente;

    public ServicoRelatorio(IRepCliente repCliente) {
        this.repCliente = repCliente;
    }


    public Relatorio calculaMediaValorFinalTodosOrcamentos()   {
        Relatorio relatorio = new Relatorio();

        //pegar todos os orcamentos de clientes
        List<Cliente> clientes = repCliente.allClientes();
        int quantOrcamentos = 0;
        double somaValorOrcamentos = 0;

        for (Cliente c : clientes) {
            quantOrcamentos += c.getOrcamentos().size();
            for (Orcamento o : c.getOrcamentos()) {
                somaValorOrcamentos+=o.getValorFinal();
            }
        }

        double mediaFinal =0;
        if (quantOrcamentos!=0) {
            mediaFinal=(somaValorOrcamentos/quantOrcamentos); 
        }
        

        relatorio.adicionarSecao("Total de orçamentos = "+quantOrcamentos);
        relatorio.adicionarSecao("Soma dos valores finais = "+somaValorOrcamentos);
        relatorio.adicionarSecao("Média = soma/total = "+mediaFinal);

        return relatorio;
    }

    public Relatorio calculaMediaComprasUltimosSeisMesesClientes()  {
        Relatorio relatorio = new Relatorio();

        //primeiro vamos somar todas as comprasUltimosMeses
        int somaComprasUltimosMeses = 0;
        int quantCli = repCliente.allClientes().size();

        for (Cliente c : repCliente.allClientes()) {
            somaComprasUltimosMeses+=c.getComprasUltimosSeisMeses();
        }

        double mediaFinal =0;
        if (quantCli!=0) {
            mediaFinal=((double)somaComprasUltimosMeses/(double)quantCli); 
        }

        relatorio.adicionarSecao("Total de clientes = "+quantCli);
        relatorio.adicionarSecao("Soma de quantidade de compras nos ultimos seis meses = "+somaComprasUltimosMeses);
        relatorio.adicionarSecao("Média de comprasUltimosSeisMeses/cliente = "+mediaFinal);

        return relatorio;
    }

    public Relatorio calculaMediaQuantidadeItensPorCompra()  {
        Relatorio relatorio = new Relatorio();


        //primeiro vamos somar todos os orcamentos
        //pegar todos os orcamentos de clientes
        List<Cliente> clientes = repCliente.allClientes();
        int quantOrcamentos = 0;
        double somaItensEmCompras = 0;

        for (Cliente c : clientes) {
            quantOrcamentos += c.getOrcamentos().size();
            for (Orcamento o : c.getOrcamentos()) {
                for (ItemPedido i : o.getPedido().getListaProdutos()) {
                    somaItensEmCompras+=i.getItemQuant();
                }
            }
        }

        double mediaFinal =0;
        if (quantOrcamentos!=0) {
            mediaFinal=(somaItensEmCompras/quantOrcamentos); 
        }

        relatorio.adicionarSecao("Total de orçamentos efetivados = "+quantOrcamentos);
        relatorio.adicionarSecao("Soma de quantidade de itens = "+somaItensEmCompras);
        relatorio.adicionarSecao("Média de itens/orçamento = "+mediaFinal);

        return relatorio;
    }

}