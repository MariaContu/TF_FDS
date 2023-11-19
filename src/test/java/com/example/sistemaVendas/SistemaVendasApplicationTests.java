package com.example.sistemaVendas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepCliente;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@SpringBootTest
class SistemaVendasApplicationTests {

	@Autowired
    private IRepProdutos repProdutos;
	@Autowired
    private IRepCliente repCliente;
	@Autowired
    private ServicoVendas servicoVendas;


	@Test
	void contextLoads() {
	}

	@Test
	void testaCustoDoPedido()	{
		List<ItemPedido> listaPedido = new LinkedList<>();
		listaPedido.add(new ItemPedido(1, 10));
		listaPedido.add(new ItemPedido(2, 15));
		Pedido novoPedido = new Pedido(1, 2, listaPedido);
		Orcamento novOrcamento = new Orcamento(1,new Date(),"Joaquim",novoPedido);
		servicoVendas.calculaCustoPedido(novOrcamento);
		double custoCalculado = novOrcamento.getCustoPedido();
		assertEquals(140.00, custoCalculado,0.01,"Custo do pedido incorreto.");
	}

	@Test
	void testaValorFinalComDescontoPadrao()	{
		List<ItemPedido> listaPedido = new LinkedList<>();
		listaPedido.add(new ItemPedido(1, 10));
		listaPedido.add(new ItemPedido(2, 15));
		Pedido novoPedido = new Pedido(1, 2, listaPedido);
		Orcamento novOrcamento = new Orcamento(1,new Date(),"Joaquim",novoPedido);
		servicoVendas.calculaCustoPedido(novOrcamento);
		servicoVendas.calculaValorFinal(novOrcamento);
		double valorFinalCalculado = novOrcamento.getValorFinal();
		assertEquals(146.3, valorFinalCalculado,0.01,"Custo do pedido incorreto.");
	}

	@Test
	void testaValorFinalSemDescontos()	{
		List<ItemPedido> listaPedido = new LinkedList<>();
		listaPedido.add(new ItemPedido(1, 2));
		listaPedido.add(new ItemPedido(2, 2));
		Pedido novoPedido = new Pedido(1, 2, listaPedido);
		Orcamento novOrcamento = new Orcamento(1,new Date(),"Joaquim",novoPedido);
		servicoVendas.calculaCustoPedido(novOrcamento);
		servicoVendas.calculaValorFinal(novOrcamento);
		double valorFinalCalculado = novOrcamento.getValorFinal();
		assertEquals(23.1, valorFinalCalculado,0.01,"Custo do pedido incorreto.");
	}

	@Test
	void testaValorFinalComDescontoDeCliente()	{
		List<ItemPedido> listaPedido = new LinkedList<>();
		listaPedido.add(new ItemPedido(1, 3));
		listaPedido.add(new ItemPedido(2, 2));
		Pedido novoPedido = new Pedido(1, 1, listaPedido);
		Orcamento novOrcamento = new Orcamento(1,new Date(),"Ana",novoPedido);
		servicoVendas.calculaCustoPedido(novOrcamento);
		servicoVendas.calculaValorFinal(novOrcamento);
		double valorFinalCalculado = novOrcamento.getValorFinal();
		assertEquals(18.87, valorFinalCalculado,0.01,"Custo do pedido incorreto.");
	}

	@Test
	void testaValidade()	{
		
	}

}
