package com.example.sistemaVendas.Aplicacao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.services.ServicoCliente;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@Component
public class SolicitarOrcamento {
    @Autowired
    private ServicoVendas servicoVendas;
    @Autowired
    private ServicoCliente servicoCliente;

    public Orcamento solicitarOrcamento(long id, Date data, String nomeCliente, Pedido pedido)    {
        //verifica se o id do cliente no pedido combina com o nome fornecido
        if (servicoCliente.findClienteById(pedido.getClienteId()).getName().equals(nomeCliente)) {
            Orcamento novoOrcamento = new Orcamento(id,data,nomeCliente,pedido);
            servicoVendas.calculaCustoPedido(novoOrcamento);
            //nao possui a verificacao de disponibilidade, apenas ao efetivar
            servicoVendas.calculaValorFinal(novoOrcamento);
            servicoVendas.addOrcamento(novoOrcamento);
            return servicoVendas.findByIdOrcamento(id);
        }
        else    {
            throw new IllegalArgumentException("Nome do cliente do orcamento não bate com id de cliente do pedido.");
        }
    }
}
