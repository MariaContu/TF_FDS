package com.example.sistemaVendas.Dominio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sistemaVendas.Dominio.interface_repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.interface_repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.interface_repositories.IRepPedido;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;

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
        return repOrcamentos.listarOrcamentos();
    }

    public void addOrcamento(Orcamento o)   {
        repOrcamentos.adicionarOr(o);
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

    public void adicionarProdutoAoPedido(long idPedido, List<ItemPedido> novosItens) {
        repPedido.adicionarProd(idPedido, novosItens);
    }

    public void retirarProdutoDoPedido(long idPedido, List<ItemPedido> itensRetirados) {
        repPedido.retirarProds(idPedido, itensRetirados);
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
        return repOrcamentos.obterOrcamentosPorId(id);
    }
}
