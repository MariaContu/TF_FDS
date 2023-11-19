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
import com.example.sistemaVendas.Dominio.model.Cliente;
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
		assertEquals(140.00, custoCalculado,0.01,"Custo do pedido incorreto.");
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
		assertEquals(146.3, valorFinalCalculado,0.01,"Valor Final Com Desconto Padrao incorreto.");
	}

	@Test
	void testaValorFinalSemDescontos()	{
		List<ItemPedido> listaPedido = new LinkedList<>();
		listaPedido.add(new ItemPedido(1, 2));
		listaPedido.add(new ItemPedido(2, 2));
		Pedido novoPedido = new Pedido(1, 2, listaPedido);
		Orcamento novOrcamento = new Orcamento(1,new Date(),"Augusto",novoPedido);
		servicoVendas.calculaCustoPedido(novOrcamento);
		servicoVendas.calculaValorFinal(novOrcamento);
		double valorFinalCalculado = novOrcamento.getValorFinal();
		assertEquals(23.1, valorFinalCalculado,0.01,"Valor Final Sem Descontos incorreto.");
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
	void testaAtualizacaoQuantidadeDeEstoque()	{
		//pedindo cafe
		ItemEstoque itemPedido = servicoEstoque.encontrarItemEstoquePorProdutoID(1);
		servicoEstoque.retiraQuantItem(itemPedido, 10);
		int quantFinal = servicoEstoque.encontrarItemEstoquePorProdutoID(1).getQuantAtual();
		assertEquals(140, quantFinal, "Quantidade não atualizada ou atualizada da maneira incorreta");
	}

	

}
