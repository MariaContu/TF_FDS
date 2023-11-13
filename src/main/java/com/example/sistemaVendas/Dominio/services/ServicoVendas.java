package com.example.sistemaVendas.Dominio.services;

import com.example.sistemaVendas.Dominio.repositories.IRepOrcamentos;

public class ServicoVendas {
    private IRepOrcamentos orcamentosRep;

    public ServicoVendas(IRepOrcamentos orcamentosRep)   {
        this.orcamentosRep=orcamentosRep;
    }
}
