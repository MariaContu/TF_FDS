package com.example.sistemaVendas.Aplicacao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;

@Component
public class EfetivarOrcamento {
    @Autowired
    private ServicoVendas servicoVendas;

    public Orcamento efetivOrcamento(long idOrcamento, Date dataEfetivacao)    {
        Orcamento o = servicoVendas.findByIdOrcamento(idOrcamento);
        //primeiro verifica a validade  da data
        if (servicoVendas.verificaValidade(o)) {
            //se for valido verificamos se os itens estao disponiveis
            if (servicoVendas.verificaDisponibilidadeItens(o.getPedido().getListaProdutos())) {
                //se verificar e os itens estiverem disponiveis, vamos retirar do estoque as quantidades
                //TODO logica itens estoque

                //entao marcamos como efetivado = true
            }
        }
        //nao passou nas condicoes = retorna orcamento com efetivado false
        return o;
    }
}
