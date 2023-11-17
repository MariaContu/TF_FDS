package com.example.sistemaVendas.Aplicacao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@Component
public class SolicitarOrcamento {
    @Autowired
    private ServicoVendas servicoVendas;

    public Orcamento solicitarOrcamento(long id, Date data, String nomeCliente, Pedido pedido)    {
        Orcamento novoOrcamento = new Orcamento(id,data,nomeCliente,pedido);
        servicoVendas.calculaCustoPedido(novoOrcamento);
        //servicoVendas.calculaValorFinal(novoOrcamento);
        servicoVendas.addOrcamento(novoOrcamento);
        return servicoVendas.findByIdOrcamento(id);
    }
}