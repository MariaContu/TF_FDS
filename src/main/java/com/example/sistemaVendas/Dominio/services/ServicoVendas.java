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

    public void addOrcamento(Orcamento o)   {
        repOrcamentos.addOrcamento(o);
    }

    public void atualizarEfetivadoOrcamento(Orcamento orcamento, boolean efetivado) {
        repOrcamentos.attEfetivado(orcamento, efetivado);
    }

    public void atualizarValidoOrcamento(Orcamento orcamento, boolean valido) {
        repOrcamentos.attValido(orcamento, valido);
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

    public void calculaCustoPedido(Orcamento orcamento) {
        repOrcamentos.calculaCustoPedido(orcamento);
    }

    public void calculaValorFinal(Orcamento orcamento) {
        repOrcamentos.calculaValorFinal(orcamento);
    }

    public boolean verificaDisponibilidadeItens(List<ItemPedido> itensPedido)    {
        return repOrcamentos.verificaDisponibilidadeItens(itensPedido);
    }

    public Orcamento findByIdOrcamento(long id)    {
        return repOrcamentos.findByIdOrcamento(id);
    }
}