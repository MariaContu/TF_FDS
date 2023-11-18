package com.example.sistemaVendas.Aplicacao.model;

import com.example.sistemaVendas.Aplicacao.SolicitarOrcamento;
import com.example.sistemaVendas.Dominio.model.Orcamento;

import java.util.List;

public class Relatorio {

    private SolicitarOrcamento solicitarOrcamento;

    public double calcularMedia(Orcamento orcamento) {
        return 0;
    }

    public double calcularDesvioPadrao(Orcamento orcamento) {
        if (orcamento == null || orcamento.getValores() == null || orcamento.getValores().isEmpty()) {
            throw new IllegalArgumentException("O orcamento ou a lista de valores não pode ser nula ou vazia.");
        }

        List<Double> valores = orcamento.getValores();
        double media = calcularMedia(orcamento);
        double somaQuadradosDiferencas = 0;

        for (Double valor : valores) {
            somaQuadradosDiferencas += Math.pow(valor - media, 2);
        }

        double variancia = somaQuadradosDiferencas / valores.size();
        return Math.sqrt(variancia);
    }

    public int contarItensAcimaLimite(List<Integer> valores, int limite) {
        if (valores == null) {
            throw new IllegalArgumentException("A lista de valores não pode ser nula.");
        }

        int count = 0;
        for (Integer valor : valores) {
            if (valor > limite) {
                count++;
            }
        }
        
        return count;
    }
}
