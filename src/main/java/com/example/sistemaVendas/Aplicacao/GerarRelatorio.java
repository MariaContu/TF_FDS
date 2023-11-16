package com.example.sistemaVendas.Aplicacao;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;

import java.util.List;

public class GerarRelatorio {

    // Exemplo de método para gerar relatório de todos os orçamentos
    public void gerarRelatorioOrcamentos(List<Orcamento> orcamentos) {
        System.out.println("Relatório de Orçamentos:");

        for (Orcamento orcamento : orcamentos) {
            System.out.println("ID: " + orcamento.getId());
            System.out.println("Cliente: " + orcamento.getNomeCliente());
            System.out.println("Data: " + orcamento.getData());
            System.out.println("Valor Final: " + orcamento.getValorFinal());
            System.out.println("Efetivado: " + orcamento.getEfetivado());
            System.out.println("------------------------------");
        }
    }

    // Exemplo de método para gerar relatório de todos os pedidos
    public void gerarRelatorioPedidos(List<Pedido> pedidos) {
        System.out.println("Relatório de Pedidos:");

        for (Pedido pedido : pedidos) {
            System.out.println("ID do Pedido: " + pedido.getId());
            System.out.println("Cliente ID: " + pedido.getClienteId());
            System.out.println("Itens do Pedido:");

            for (int i = 0; i < pedido.getListaProdutos().size(); i++) {
                System.out.println("Item " + (i + 1) + ": ID " + pedido.getListaProdutos().get(i).getItemId() +
                        ", Quantidade: " + pedido.getListaProdutos().get(i).getItemQuant());
            }

            System.out.println("------------------------------");
        }
    }

    public void gerarRelatorioItensEstoque(List<ItemEstoque> itensEstoque) {
        System.out.println("Relatório de Itens de Estoque:");

        for (ItemEstoque item : itensEstoque) {
            System.out.println("ID do Item: " + item.getId());
            System.out.println("Produto ID: " + item.getCodigoProduto());
            System.out.println("Quantidade Atual: " + item.getQuantAtual());
            System.out.println("Quantidade Mínima: " + item.getQuantMin());
            System.out.println("Quantidade Máxima: " + item.getQuantMax());
            System.out.println("------------------------------");
        }
    }

    public void gerarRelatorioClientes(List<Cliente> clientes) {
        System.out.println("Relatório de Clientes:");

        for (Cliente cliente : clientes) {
            System.out.println("ID do Cliente: " + cliente.getId());
            System.out.println("Nome: " + cliente.getName());
            System.out.println("Valor Médio de Compras: " + cliente.getValorMedio());
            System.out.println("Compras dos Ultimos 6 Meses: " + cliente.getComprasUltimosSeisMeses());
            System.out.println("------------------------------");
        }
    }

    public void gerarRelatorioProdutos(List<Produto> produtos) {
        System.out.println("Relatório de Produtos:");

        for (Produto produto : produtos) {
            System.out.println("ID do Produto: " + produto.getCodigo());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Preço Unitário: " + produto.getPrecoUnit());
            System.out.println("------------------------------");
        }
    }

    public void gerarRelatorioGalpao(List<ItemEstoque> itensEstoque) {
        System.out.println("Relatório do Galpão:");

        for (ItemEstoque item : itensEstoque) {
            System.out.println("ID do Item: " + item.getId());
            System.out.println("Produto ID: " + item.getCodigoProduto());
            System.out.println("Quantidade Atual: " + item.getQuantAtual());
            System.out.println("Quantidade Mínima: " + item.getQuantMin());
            System.out.println("Quantidade Máxima: " + item.getQuantMax());
            System.out.println("------------------------------");
        }
    }
}
