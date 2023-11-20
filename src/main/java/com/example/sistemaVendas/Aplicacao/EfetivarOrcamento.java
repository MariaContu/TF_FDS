package com.example.sistemaVendas.Aplicacao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
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
        if(servicoVendas.verificaValidade(o)){
            if(servicoVendas.verificaDisponibilidadeItens(o.getPedido().getListaProdutos())){
                List<ItemPedido> list = o.getPedido().getListaProdutos();

                for (ItemPedido item: list) {
                    servicoEstoque.retiraQuantItem(item.getItemId(), item.getItemQuant());
                }

                servicoVendas.atualizarEfetivadoOrcamento(o, true);

                servicoCliente.addPedido(servicoCliente.findClienteByName(o.getNomeCliente()), o);
                
                servicoCliente.atualizaValorMedio(servicoCliente.findClienteByName(o.getNomeCliente()));
                servicoCliente.atualizaComprasUltimosMeses(servicoCliente.findClienteByName(o.getNomeCliente()));
            }
        }
        return o;
    }
}
