package com.example.sistemaVendas.Aplicacao;

import com.example.sistemaVendas.Dominio.model.Cliente;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;
import com.example.sistemaVendas.Dominio.services.ServicoVendas;
import org.springframework.stereotype.Component;

@Component
public class EfetivarOrcamento {

    private final IRepOrcamentos repOrcamentos;
    private final ServicoVendas servicoVendas;

    public EfetivarOrcamento(IRepOrcamentos repOrcamentos, ServicoVendas servicoVendas) {
        this.repOrcamentos = repOrcamentos;
        this.servicoVendas = servicoVendas;
    }

    public void efetivarOrcamento(long orcamentoId) {
        Orcamento orcamento = repOrcamentos.findOrcamentoById(orcamentoId);

        if (orcamento != null && orcamento.getValido() && !orcamento.getEfetivado()) {
            Cliente cliente = servicoVendas.findClienteById(orcamento.getPedido().getClienteId());

            if (cliente != null) {
                if (servicoVendas.verificaValidade(orcamento)) {
                    double descontoCliente = servicoVendas.descontoDeCliente(cliente);
                    double valorFinalComDesconto = orcamento.getValorFinal() * (1 - descontoCliente);

                    orcamento.setValorFinal(valorFinalComDesconto);
                    orcamento.setEfetivado(true);

                    // Atualizar o estado do orcamento no repositório
                    repOrcamentos.attEfetivado(orcamento);

                    System.out.println("Orcamento efetivado com sucesso!");
                } else {
                    System.out.println("Orcamento inválido devido à sua data de validade expirada.");
                }
            } else {
                System.out.println("Cliente não encontrado para o ID do cliente associado ao orcamento.");
            }
        } else {
            System.out.println("Orcamento não encontrado, inválido ou já efetivado.");
        }
    }
}
