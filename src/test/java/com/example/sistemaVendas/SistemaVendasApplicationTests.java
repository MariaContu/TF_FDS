package com.example.sistemaVendas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepProdutos;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@SpringBootTest
class SistemaVendasApplicationTests {

	@Mock
    private IRepProdutos repProdutos;

    @InjectMocks
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
		double custoEsperado = 140.00;
		assertEquals(custoEsperado, custoCalculado,0.01);
	}

	@Test
	void testaValorFinal()	{
		
	}

	@Test
	void testaValidade()	{
		
	}

}
