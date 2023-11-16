package com.example.sistemaVendas.Persistencias.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;

@Repository
public class RepOrcamentosORM implements IRepOrcamentos{
    private List<Orcamento> orcamentos;
    private IRepProdutos repProdutos;
    private IRepCliente repCliente;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaValidade'");
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

        //verifica se tem desconto por 5 itens
        if (orcamento.getPedido().getListaProdutos().size()>5) {
            valorFinal=valorFinal*orcamento.getDesconto();
        }

        //vamos verificar se o desconto do cliente eh diferente de 0
        if (repCliente.descontoDeCliente(repCliente.findByName(orcamento.getNomeCliente()))!=0) {
            double desconto = repCliente.descontoDeCliente(repCliente.findByName(orcamento.getNomeCliente()));
            valorFinal = valorFinal*desconto;
        }

        //verifica disponibilidade de itens

    }

    @Override
    public boolean verificaDisponibilidadeItens(Orcamento orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaDisponibilidadeItens'");
    }

}
