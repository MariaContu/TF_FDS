package com.example.sistemaVendas.Interface;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaVendas.Aplicacao.EfetivarOrcamento;
import com.example.sistemaVendas.Aplicacao.ProdutosDisponiveis;
import com.example.sistemaVendas.Aplicacao.SolicitarOrcamento;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Produto;

@RestController
public class Controller {
    @Autowired
    private ProdutosDisponiveis produtosDisponiveis;
    @Autowired
    private SolicitarOrcamento solicitaOrcamento;
    @Autowired
    private EfetivarOrcamento efetivaOrcamento;

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

    //api de teste
    @GetMapping("id={id}")
    @CrossOrigin("*")
    public Produto byId(@PathVariable long id) {
        return produtosDisponiveis.findByID(id);
    }

    @PostMapping("solicitarOrcamento")
    @CrossOrigin("*")
    public ResponseEntity<Orcamento> solicitaOrcamento(@RequestBody Orcamento novoOrcamento)    {
        Orcamento orcamento = solicitaOrcamento.solicitarOrcamento(novoOrcamento.getId(),novoOrcamento.getData(),novoOrcamento.getNomeCliente(),novoOrcamento.getPedido());
        return ResponseEntity.ok(orcamento);
    }

    @PatchMapping("efetivarOrcamento/id={id}/data aaaa/mm/dd={data}")
    @CrossOrigin("*")
    public ResponseEntity<Orcamento> efetivaOrcamento(@PathVariable("id") long idOrcamento, @PathVariable("data") @DateTimeFormat(pattern = "yyyy/MM/dd") Date dataEfetivacao) {
        Orcamento orcamento = efetivaOrcamento.efetivarOrcamento(idOrcamento, dataEfetivacao);
        return ResponseEntity.ok(orcamento);
    }
}
