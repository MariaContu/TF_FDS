package com.example.sistemaVendas.Aplicacao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.services.ServicoCliente;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@Component
public class EfetivarOrcamento {
    @Autowired
    private ServicoVendas servicoVendas;
    @Autowired
    private ServicoEstoque servicoEstoque;
    @Autowired
    private ServicoCliente servicoCliente;

    public Orcamento efetivarOrcamento(long idOrcamento, Date dataEfetivacao)    {
        Orcamento o = servicoVendas.findByIdOrcamento(idOrcamento);
        //primeiro verifica a validade  da data
        if (servicoVendas.verificaValidade(o)) {
            //se for valido verificamos se os itens estao disponiveis
            if (servicoVendas.verificaDisponibilidadeItens(o.getPedido().getListaProdutos())) {
                List<ItemPedido> lista = o.getPedido().getListaProdutos();

                //se verificar e os itens estiverem disponiveis, vamos retirar do estoque as quantidades
                for (ItemPedido i : lista) {
                    ItemEstoque itemEstoque = servicoEstoque.encontrarItemEstoquePorProdutoID(i.getItemId());
                    servicoEstoque.retiraQuantItem(itemEstoque, i.getItemQuant());
                    
                }
                
                //entao marcamos como efetivado = true
                servicoVendas.atualizarEfetivadoOrcamento(o, true);

                //ao efetivar, adicionamos o pedido a lista do cliente
                servicoCliente.addPedido(servicoCliente.findClienteByName(o.getNomeCliente()), o);

                //atualizamos as variaveis: valor medio e comprasUltimosSeisMeses
                servicoCliente.atualizaValorMedio(servicoCliente.findClienteByName(o.getNomeCliente()));
                servicoCliente.atualizaComprasUltimosMeses(servicoCliente.findClienteByName(o.getNomeCliente()));

            }
        }
        else servicoVendas.atualizarValidoOrcamento(o,false);
        //nao passou nas condicoes = retorna orcamento com efetivado false
        return o;
    }
}