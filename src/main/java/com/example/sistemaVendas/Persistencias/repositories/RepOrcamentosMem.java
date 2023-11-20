package com.example.sistemaVendas.Persistencias.repositories;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.interface_repositories.IRepGalpao;
import com.example.sistemaVendas.Dominio.interface_repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.interface_repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Produto;

@Repository
public class RepOrcamentosMem implements IRepOrcamentos{

    private List<Orcamento> orcs;

    @Autowired
    private IRepCliente repCliente;
    @Autowired
    private IRepGalpao repGalpao;
    @Autowired
    private IRepProdutos repProdutos;

    public RepOrcamentosMem(){
        orcs = new LinkedList<>();
    }

    @Override
    public List<Orcamento> listarOrcamentos() {
        return orcs;
    }

    @Override
    public Orcamento obterOrcamentosPorId(long orcId) {
        for (Orcamento orc : orcs) {
            if(orc.getId() == orcId){
                return orc;
            }
        }
        return null;
    }

    @Override
    public void adicionarOr(Orcamento orcamento) {
        orcs.add(orcamento);
    }

    @Override
    public void attEfetivado(Orcamento orcamento, boolean efetivado) {
        orcamento.setEfetivado(efetivado);
    }

    @Override
    public void attValido(Orcamento orcamento, boolean valido) {
        orcamento.setValidez(valido);
    }


    //Verifica se nao passou dos 21 dias de validade
    @Override
    public boolean verificaValidade(Orcamento orcamento) {
        Date dataInicial = orcamento.getData();
        Date dataFinal;
        int diasValidade=21;

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(dataInicial);
        int mes=calendario.get(Calendar.MONTH);

        //verifica se eh janeiro ou fevereiro
        if (mes == Calendar.JANUARY || mes == Calendar.FEBRUARY) {
            diasValidade = 35;
        }

        // Adiciona os dias de validade à data inicial para obter a data final
        calendario.add(Calendar.DAY_OF_MONTH, diasValidade);
        dataFinal = calendario.getTime();

        // Compara a data atual com a data final
        return new Date().before(dataFinal);
    }

    @Override
    public void calculaCustoPedido(Orcamento orcamento) {
        double custo = 0;
        for (ItemPedido item : orcamento.getPedido().getListaProdutos()) {
            for (Produto produto : repProdutos.all()) {
                if(produto.getCodigo() ==  repGalpao.obterItemEstoquePorIdProduto(item.getItemId()).getCodigoProduto()){
                    custo += produto.getPrecoUnit()*item.getItemQuant();
                }
            }
        }
        orcamento.setCustoPedido(custo);
    }

    @Override
    public void calculaValorFinal(Orcamento orcamento) {
        double valorPedido = orcamento.getCustoPedido();
        double valorFinal = valorPedido * orcamento.getImposto(); //pedido com imposto

        List<ItemPedido> listaPedido = orcamento.getPedido().getListaProdutos();
        int somaItens=0;

        //verifica se tem desconto por 5 itens
        for (ItemPedido item : listaPedido) {
           somaItens+=item.getItemQuant();
        }
        if (somaItens>5) {
            valorFinal=valorFinal*orcamento.getDesconto();
        }

        //vamos verificar se o desconto do cliente eh diferente de 0
        if (repCliente.descontoDeCliente(repCliente.findByName(orcamento.getNomeCliente()))!=0) {
            double desconto = repCliente.descontoDeCliente(repCliente.findByName(orcamento.getNomeCliente()));
            valorFinal = valorFinal*desconto;
        }

        BigDecimal valorFinalBD = BigDecimal.valueOf(valorFinal);
        valorFinalBD = valorFinalBD.setScale(2, RoundingMode.HALF_UP);
        valorFinal = valorFinalBD.doubleValue();


        orcamento.setValorFinal(valorFinal);
    }

    @Override
    public boolean verificaDisponibilidadeItens(List<ItemPedido> itensPedido) {
        for (ItemPedido item : itensPedido) {
            if(repGalpao.obterItemEstoquePorIdProduto(item.getItemId()) == null || repGalpao.obterItemEstoquePorIdProduto(item.getItemId()).getQuantAtual() < item.getItemQuant() ||(repGalpao.obterItemEstoquePorIdProduto(item.getItemId()).getQuantAtual() - item.getItemQuant()) < repGalpao.obterItemEstoquePorIdProduto(item.getItemId()).getQuantMin()){
                System.out.println("Não há estoque suficiente para o item com ID: " + item.getItemId());
                return false;
            }
        }
        return true;
    }

 
    
}
