package com.example.sistemaVendas;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

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
		
	}

	@Test
	void testaValorFinal()	{
		
	}

	@Test
	void testaValidade()	{
		
	}

}
