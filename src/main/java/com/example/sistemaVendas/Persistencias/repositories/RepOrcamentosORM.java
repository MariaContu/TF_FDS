package com.example.sistemaVendas.Persistencias.repositories;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.repositories.IRepItemEstoque;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;

@Repository
public class RepOrcamentosORM implements IRepOrcamentos{
    private List<Orcamento> orcamentos;
    @Autowired
    private IRepProdutos repProdutos;
    @Autowired
    private IRepCliente repCliente;
    @Autowired
    private IRepItemEstoque repItemEstoque;


    public RepOrcamentosORM(){
        orcamentos = new LinkedList<>();
    }

    @Override
    public List<Orcamento> all() {
        return orcamentos;
    }
    
    @Override
    public void addOrcamento(Orcamento o) {
        orcamentos.add(o);
    }
    
    @Override
    public void attEfetivado(Orcamento orcamento, boolean efetivado) {
        orcamento.setEfetivado(efetivado);
    }

    @Override
    public void attValido(Orcamento orcamento, boolean valido) {
        orcamento.setValido(valido);
    }

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
        List<ItemPedido> itensPedido = orcamento.getPedido().getListaProdutos();
        double soma=0;

        for (ItemPedido iP : itensPedido) {
            int quant=iP.getItemQuant();
            double preçoBase=repProdutos.findById(iP.getItemId()).getPrecoUnit();

            double custoItem=preçoBase*quant;

            soma+=custoItem;
        }

        orcamento.setCustoPedido(soma);
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
            ItemEstoque itemEstoque = repItemEstoque.findItemEstoqueByProdutoID(item.getItemId());
            // Verifica se o item existe e se a quantidade após a venda é maior ou igual à quantidade mínima
            if (itemEstoque == null || 
                itemEstoque.getQuantAtual() < item.getItemQuant() ||
                (itemEstoque.getQuantAtual() - item.getItemQuant()) < itemEstoque.getQuantMin()) {
                
                System.out.println("Não há estoque suficiente para o item com ID: " + item.getItemId());
                return false;
            }
        }
        return true;
    }

    @Override
    public Orcamento findByIdOrcamento(long id) {
        for (Orcamento o : orcamentos) {
            if (id==o.getId()) {
                return o;
            }
        }
        return null;
    }
}
