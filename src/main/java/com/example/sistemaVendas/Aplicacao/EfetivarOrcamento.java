package com.example.sistemaVendas.Aplicacao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.services.ServicoEstoque;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@Component
public class EfetivarOrcamento {
    @Autowired
    private ServicoVendas servicoVendas;
    @Autowired
    private ServicoEstoque servicoEstoque;

    public Orcamento efetivarOrcamento(long idOrcamento, Date dataEfetivacao)    {
        Orcamento o = servicoVendas.findByIdOrcamento(idOrcamento);
        //primeiro verifica a validade  da data
        if (servicoVendas.verificaValidade(o)) {
            //se for valido verificamos se os itens estao disponiveis
            if (servicoVendas.verificaDisponibilidadeItens(o.getPedido().getListaProdutos())) {
                List<ItemPedido> lista = o.getPedido().getListaProdutos();

                //se verificar e os itens estiverem disponiveis, vamos retirar do estoque as quantidades
                //TODO logica itens estoque
                for (ItemPedido i : lista) {
                    ItemEstoque itemEstoque = servicoEstoque.encontrarItemEstoquePorProdutoID(i.getItemId());
                    servicoEstoque.retiraQuantItem(itemEstoque, i.getItemQuant());
                }
                //entao marcamos como efetivado = true
                servicoVendas.atualizarEfetivadoOrcamento(o, true);
            }
        }
        else servicoVendas.atualizarValidoOrcamento(o,false);
        //nao passou nas condicoes = retorna orcamento com efetivado false
        return o;
    }
}
