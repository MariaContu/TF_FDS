package com.example.sistemaVendas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.services.ServicoCliente;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@SpringBootTest
class SistemaVendasApplicationTests {

	@Autowired
    private ServicoVendas servicoVendas;
	@Autowired
    private ServicoEstoque servicoEstoque;	
	@Autowired
	private ServicoCliente servicoCliente;

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
		assertEquals(35805.00, custoCalculado,0.1,"Custo do pedido incorreto.");
	}

	@Test
	void testaValorFinalComDescontoPadrao()	{
		List<ItemPedido> listaPedido = new LinkedList<>();
		listaPedido.add(new ItemPedido(1, 10));
		listaPedido.add(new ItemPedido(2, 15));
		Pedido novoPedido = new Pedido(1, 2, listaPedido);
		Orcamento novOrcamento = new Orcamento(1,new Date(),"Augusto",novoPedido);
		servicoVendas.calculaCustoPedido(novOrcamento);
		servicoVendas.calculaValorFinal(novOrcamento);
		double valorFinalCalculado = novOrcamento.getValorFinal();
		assertEquals(37416.2, valorFinalCalculado,0.1,"Valor Final Com Desconto Padrao incorreto.");
	}

	@Test
	void testaValorFinalSemDescontos()	{
		List<ItemPedido> listaPedido = new LinkedList<>();
		listaPedido.add(new ItemPedido(1, 2));
		listaPedido.add(new ItemPedido(2, 2));
		Pedido novoPedido = new Pedido(1, 4, listaPedido);
		Orcamento novOrcamento = new Orcamento(1,new Date(),"Augusto",novoPedido);
		servicoVendas.calculaCustoPedido(novOrcamento);
		servicoVendas.calculaValorFinal(novOrcamento);
		double valorFinalCalculado = novOrcamento.getValorFinal();
		assertEquals(5787.1, valorFinalCalculado,0.1,"Valor Final Sem Descontos incorreto.");
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
		assertEquals(4613.46, valorFinalCalculado,0.1,"Custo do pedido incorreto.");
	}

	@Test
	void testaValidadeOrçamentoValido() {
		// Setup
		Orcamento orcamentoValido = new Orcamento();
		orcamentoValido.setData(new Date()); // Data atual para o teste

		boolean resultadoAtual = servicoVendas.verificaValidade(orcamentoValido);

		boolean resultadoEsperado = true;
		assertEquals(resultadoEsperado, resultadoAtual, "O orçamento deveria ser considerado válido.");
	}

	@Test
	void testaValidadeOrçamentoExpirado() {
		Calendar dataExpirada = Calendar.getInstance();
		dataExpirada.add(Calendar.YEAR, -1); // Data definida para um ano atrás para garantir expiração

		Orcamento orcamentoExpirado = new Orcamento();
		orcamentoExpirado.setData(dataExpirada.getTime());

		boolean resultadoAtual = servicoVendas.verificaValidade(orcamentoExpirado);

		boolean resultadoEsperado = false;
		assertEquals(resultadoEsperado, resultadoAtual, "O orçamento deveria ser considerado inválido devido à expiração da validade.");
	}

	@Test
	void testaAtualizacaoQuantidadeDeEstoqueValida()	{
		//pedindo cafe
		ItemEstoque itemPedido = servicoEstoque.encontrarItemEstoquePorProdutoID(1);
		servicoEstoque.retiraQuantItem(itemPedido, 10);
		int quantFinal = servicoEstoque.encontrarItemEstoquePorProdutoID(1).getQuantAtual();
		assertEquals(140, quantFinal, "Quantidade não atualizada ou atualizada da maneira incorreta");
	}

	@Test
	void testaAtualizacaoValorMedioCliente()	{
		List<ItemPedido> lista1 = new LinkedList<>();
		List<ItemPedido> lista2 = new LinkedList<>();
		List<ItemPedido> lista3 = new LinkedList<>();
		lista1.add(new ItemPedido(1,3));
		lista1.add(new ItemPedido(2,3));
		lista2.add(new ItemPedido(3,5));
		lista2.add(new ItemPedido(4,5));
		lista3.add(new ItemPedido(6,4));
		lista3.add(new ItemPedido(2,3));

		Pedido p1 = new Pedido(1,4,lista1);
		Pedido p2 = new Pedido(2,4,lista2);
		Pedido p3 = new Pedido(3,4,lista3);

		// Definindo o valorFinal para cada Orcamento
		Orcamento o1 = new Orcamento(1, new Date(), "Augusto", p1);
		servicoVendas.calculaCustoPedido(o1);
		servicoVendas.calculaValorFinal(o1); //"valorFinal": 8246.62
		Orcamento o2 = new Orcamento(2, new Date(), "Augusto", p2);
		servicoVendas.calculaCustoPedido(o2);
		servicoVendas.calculaValorFinal(o2); //"valorFinal": 5123.11
		Orcamento o3 = new Orcamento(3, new Date(), "Augusto", p3);
		servicoVendas.calculaCustoPedido(o3);
		servicoVendas.calculaValorFinal(o3); //"valorFinal": 11808.5

		servicoCliente.addPedido(servicoCliente.findClienteById(4), o1);
		servicoCliente.addPedido(servicoCliente.findClienteById(4), o2);
		servicoCliente.addPedido(servicoCliente.findClienteById(4), o3);

		servicoCliente.atualizaValorMedio(servicoCliente.findClienteById(4));
		assertEquals(8392.74, servicoCliente.findClienteById(4).getValorMedio(),0.1);
	}

	@Test
	void testaAtualizacaoComprasUltimosMeses()	{
		List<ItemPedido> lista1 = new LinkedList<>();
		List<ItemPedido> lista2 = new LinkedList<>();
		List<ItemPedido> lista3 = new LinkedList<>();
		lista1.add(new ItemPedido(1,3));
		lista1.add(new ItemPedido(2,3));
		lista2.add(new ItemPedido(3,5));
		lista2.add(new ItemPedido(4,5));
		lista3.add(new ItemPedido(6,4));
		lista3.add(new ItemPedido(2,3));

		Pedido p1 = new Pedido(1,4,lista1);
		Pedido p2 = new Pedido(2,4,lista2);
		Pedido p3 = new Pedido(3,4,lista3);

		// Definindo o valorFinal para cada Orcamento
		Orcamento o1 = new Orcamento(1, new Date(), "Augusto", p1);
		servicoVendas.calculaCustoPedido(o1);
		servicoVendas.calculaValorFinal(o1); //"valorFinal": 8246.62
		Orcamento o2 = new Orcamento(2, new Date(), "Augusto", p2);
		servicoVendas.calculaCustoPedido(o2);
		servicoVendas.calculaValorFinal(o2); //"valorFinal": 5123.11
		Orcamento o3 = new Orcamento(3, new Date(), "Augusto", p3);
		servicoVendas.calculaCustoPedido(o3);
		servicoVendas.calculaValorFinal(o3); //"valorFinal": 11808.5

		servicoCliente.addPedido(servicoCliente.findClienteById(4), o1);
		servicoCliente.addPedido(servicoCliente.findClienteById(4), o2);
		servicoCliente.addPedido(servicoCliente.findClienteById(4), o3);

		servicoCliente.atualizaComprasUltimosMeses(servicoCliente.findClienteById(4));
		assertEquals(3, servicoCliente.findClienteById(4).getComprasUltimosSeisMeses(),0.1);

	}
}
