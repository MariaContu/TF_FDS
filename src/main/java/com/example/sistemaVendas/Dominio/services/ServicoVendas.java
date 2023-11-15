package com.example.sistemaVendas.Dominio.services;

import com.example.sistemaVendas.Dominio.repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.repositories.IRepPedido;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.ItemPedido;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServicoVendas {

    private IRepOrcamentos repOrcamentos;
    private IRepPedido repPedido;
    private IRepCliente repCliente;
    
    public ServicoVendas(IRepOrcamentos repOrcamentos, IRepPedido repPedido) {
        this.repOrcamentos = repOrcamentos;
        this.repPedido = repPedido;
    }

    public List<Orcamento> listarTodosOrcamentos() {
        return repOrcamentos.all();
    }

    public void atualizarEfetivadoOrcamento(Orcamento orcamento) {
        repOrcamentos.attEfetivado(orcamento);
    }

    public void atualizarValidoOrcamento(Orcamento orcamento) {
        repOrcamentos.attValido(orcamento);
    }

    public List<Pedido> listarTodosPedidos() {
        return repPedido.all();
    }

    public List<Pedido> listarPedidosPorCliente(long clienteID) {
        return repPedido.pedidosPorCliente(clienteID);
    }

    public void adicionarProdutoAoPedido(long idPedido, ItemPedido novoItem) {
        repPedido.adicionarProd(idPedido, novoItem);
    }

    public void retirarProdutoDoPedido(long idPedido, ItemPedido itemRetirado) {
        repPedido.retirarProd(idPedido, itemRetirado);
    }

    public boolean verificaValidade(Orcamento orcamento)    {
        return repOrcamentos.verificaValidade(orcamento);
    }

    public double descontoDeCliente(Cliente cliente)  {
        return repCliente.descontoDeCliente(cliente);
    }
}
