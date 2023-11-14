package com.example.sistemaVendas.Interface;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaVendas.Aplicacao.ProdutosDisponiveis;
import com.example.sistemaVendas.Dominio.model.Produto;

@RestController
public class Controller {
    @Autowired
    private ProdutosDisponiveis produtosDisponiveis;

    @GetMapping("produtosDisponiveis")
    @CrossOrigin("*")
    public List<Produto> produtosDisponiveis() {
        return produtosDisponiveis.all();
    }
    
}
