package com.example.sistemaVendas.Interface;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaVendas.Aplicacao.ProdutosDisponiveis;
import com.example.sistemaVendas.Dominio.model.ItemPedido;
import com.example.sistemaVendas.Dominio.model.Produto;

@RestController
public class Controller {
    @Autowired
    private ProdutosDisponiveis produtosDisponiveis;

    @GetMapping("")
    @CrossOrigin("*")
    public String instrucoes() {
        return "---------------------------------------------------\n Para produtos disponíveis: /produtosDisponiveis \n Para solicitar orçamento de uma determinada lista de itens: /solicitaOrcamento/lista/{[]}";
  }

    @GetMapping("produtosDisponiveis")
    @CrossOrigin("*")
    public List<Produto> produtosDisponiveis() {
        return produtosDisponiveis.all();
    }

    @GetMapping("id={id}")
    @CrossOrigin("*")
    public Produto byId(@PathVariable long id) {
        return produtosDisponiveis.findByID(id);
    }

    @GetMapping("solicitarOrcamento")
    @CrossOrigin("*")
    public ResponseEntity solicitarOrcamento(@RequestBody List<ItemPedido> itens) {
        
        return null;
    }
    
}
