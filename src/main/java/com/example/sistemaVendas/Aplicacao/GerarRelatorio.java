package com.example.sistemaVendas.Aplicacao;

import com.example.sistemaVendas.Aplicacao.model.Relatorio;
import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Galpao;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;
import com.example.sistemaVendas.Dominio.repositories.IRepRelatorio;

import java.util.ArrayList;
import java.util.List;

public class GerarRelatorio implements IRepRelatorio {

    private List<Relatorio> relatorios;

    public GerarRelatorio() {
        this.relatorios = new ArrayList<>();
    }

    @Override
    public void gerarRelatorioCliente(Cliente cliente) {
        String conteudoRelatorio = "Relatório de Clientes:\n"
                + "ID do Cliente: " + cliente.getId() + "\n"
                + "Nome: " + cliente.getName() + "\n"
                + "Valor Médio de Compras: " + cliente.getValorMedio() + "\n"
                + "Compras dos Últimos 6 Meses: " + cliente.getComprasUltimosSeisMeses() + "\n"
                + "------------------------------";

        Relatorio relatorio = new Relatorio(conteudoRelatorio);
        System.out.println(conteudoRelatorio);
        relatorios.add(relatorio);
    }

    @Override
    public void gerarRelatorioGalpao(Galpao galpao, ItemEstoque item) {
        String conteudoRelatorio = "Relatório do Galpão:\n"
                + "ID do Item: " + item.getId() + "\n"
                + "Produto ID: " + item.getCodigoProduto() + "\n"
                + "Quantidade Atual: " + item.getQuantAtual() + "\n"
                + "Quantidade Mínima: " + item.getQuantMin() + "\n"
                + "Quantidade Máxima: " + item.getQuantMax() + "\n"
                + "------------------------------";

        Relatorio relatorio = new Relatorio(conteudoRelatorio);
        System.out.println(conteudoRelatorio);
        relatorios.add(relatorio);
    }

    @Override
    public void gerarRelatorioItemEstoque(ItemEstoque item) {
        String conteudoRelatorio = "Relatório de Itens de Estoque:\n"
                + "ID do Item: " + item.getId() + "\n"
                + "Produto ID: " + item.getCodigoProduto() + "\n"
                + "Quantidade Atual: " + item.getQuantAtual() + "\n"
                + "Quantidade Mínima: " + item.getQuantMin() + "\n"
                + "Quantidade Máxima: " + item.getQuantMax() + "\n"
                + "------------------------------";

        Relatorio relatorio = new Relatorio(conteudoRelatorio);
        System.out.println(conteudoRelatorio);
        relatorios.add(relatorio);
    }

    @Override
    public void gerarRelatorioItemPedido(ItemPedido item) {
        String conteudoRelatorio = "Relatório de Itens de Pedido:\n"
                + "ID do Item: " + item.getItemId() + "\n"
                + "Produto ID: " + item.getItemQuant() + "\n"
                + "------------------------------";

        Relatorio relatorio = new Relatorio(conteudoRelatorio);
        System.out.println(conteudoRelatorio);
        relatorios.add(relatorio);
    }

    @Override
    public void gerarRelatorioOrcamento(Orcamento orcamento) {
        String conteudoRelatorio = "Relatório de Orçamentos:\n"
                + "ID: " + orcamento.getId() + "\n"
                + "Cliente: " + orcamento.getNomeCliente() + "\n"
                + "Data: " + orcamento.getData() + "\n"
                + "Valor Final: " + orcamento.getValorFinal() + "\n"
                + "Efetivado: " + orcamento.getEfetivado() + "\n"
                + "------------------------------";

        Relatorio relatorio = new Relatorio(conteudoRelatorio);
        System.out.println(conteudoRelatorio);
        relatorios.add(relatorio);
    }

    @Override
    public void gerarRelatorioPedido(Pedido pedidos) {
        StringBuilder conteudoRelatorio = new StringBuilder();
        conteudoRelatorio.append("Relatório de Pedidos:\n")
                .append("ID do Pedido: ").append(pedidos.getId()).append("\n")
                .append("Cliente ID: ").append(pedidos.getClienteId()).append("\n")
                .append("Itens do Pedido:\n");

        for (int i = 0; i < pedidos.getListaProdutos().size(); i++) {
            conteudoRelatorio.append("Item ").append(i + 1).append(": ID ")
                    .append(pedidos.getListaProdutos().get(i).getItemId())
                    .append(", Quantidade: ").append(pedidos.getListaProdutos().get(i).getItemQuant()).append("\n");
        }

        conteudoRelatorio.append("------------------------------");

        Relatorio relatorio = new Relatorio(conteudoRelatorio.toString());
        System.out.println(conteudoRelatorio);
        relatorios.add(relatorio);
    }

    @Override
    public void gerarRelatorioProduto(Produto produto) {
        String conteudoRelatorio = "Relatório de Produtos:\n" +
                "ID do Produto: " + produto.getCodigo() + "\n" +
                "Descrição: " + produto.getDescricao() + "\n" +
                "Preço Unitário: " + produto.getPrecoUnit() + "\n" +
                "------------------------------";

        Relatorio relatorio = new Relatorio(conteudoRelatorio);
        System.out.println(conteudoRelatorio);
        relatorios.add(relatorio);
    }

    @Override
    public void salvarRelatorio(Relatorio r) {
        relatorios.add(r);
    }

    @Override
    public List<Relatorio> listarTodosRelatorios() {
        return relatorios;
    }

    @Override
    public Relatorio encontrarPorCliente(Cliente c) {
        for (Relatorio r : relatorios) {
            if (c == r.getClientes()) {
                return r;
            }
        }
        return null;
    }

    @Override
    public void removerRelatorio(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerRelatorio'");
    }
}
