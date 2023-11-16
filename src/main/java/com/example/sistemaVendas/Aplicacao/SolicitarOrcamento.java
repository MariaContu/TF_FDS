package com.example.sistemaVendas.Aplicacao;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;

import java.util.Date;
import java.util.List;

public class SolicitarOrcamento {

    private Cliente cliente;
    private List<Pedido> listaPedidos;
    private double custoTotal;

    public SolicitarOrcamento(Cliente cliente, List<Pedido> listaPedidos) {
        this.cliente = cliente;
        this.listaPedidos = listaPedidos;
        this.custoTotal = calcularCustoTotal(listaPedidos);
    }

    public Orcamento gerarOrcamento() {
        Date dataAtual = new Date();
        String nomeCliente = cliente.getName();
        long id = 1;
        double custoPedido = calcularCustoTotal(listaPedidos) * 1.1;

        return new Orcamento(id, dataAtual, nomeCliente, null);
    }

    private double calcularCustoTotal(List<Pedido> pedidos) {
        return pedidos.stream()
                .mapToDouble(pedido -> pedido.getListaProdutos().stream()
                        .mapToDouble(itemPedido -> itemPedido.getItemQuant() * itemPedido.getItemId())
                        .sum())
                .sum();
    }

    public double getCustoTotal() {
        return custoTotal;
    }
}
