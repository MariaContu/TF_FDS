package com.example.sistemaVendas.Interface;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaVendas.Aplicacao.EfetivarOrcamento;
import com.example.sistemaVendas.Aplicacao.GerarRelatorio;
import com.example.sistemaVendas.Aplicacao.ProdutosDisponiveis;
import com.example.sistemaVendas.Aplicacao.SolicitarOrcamento;
import com.example.sistemaVendas.Aplicacao.model.Relatorio;
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
    @Autowired
    private GerarRelatorio gerarRelatorio;

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

    // api de teste
    @GetMapping("id={id}")
    @CrossOrigin("*")
    public Produto byId(@PathVariable long id) {
        return produtosDisponiveis.findByID(id);
    }

    @PostMapping("solicitarOrcamento")
    @CrossOrigin("*")
    public ResponseEntity<Orcamento> solicitaOrcamento(@RequestBody Orcamento novoOrcamento) {
        Orcamento orcamento = solicitaOrcamento.solicitarOrcamento(novoOrcamento.getId(), novoOrcamento.getData(),
                novoOrcamento.getNomeCliente(), novoOrcamento.getPedido());
        return ResponseEntity.ok(orcamento);
    }

    @PutMapping("efetivarOrcamento/id={id}")
    @CrossOrigin("*")
    public ResponseEntity<Orcamento> efetivarOrcamento(@PathVariable("id") long idOrcamento) {

        Date dataAtual = new Date();
        Orcamento orcamento = efetivaOrcamento.efetivarOrcamento(idOrcamento, dataAtual);
        if (orcamento.getEfetivado()) {
            return ResponseEntity.ok(orcamento);
        } else {
            // Se o orçamento não foi efetivado, escolha um status HTTP apropriado
            // Aqui estou usando 409 Conflict, mas você pode escolher outro status que faça
            // sentido
            return ResponseEntity.status(HttpStatus.CONFLICT).body(orcamento);
        }
    }

    @GetMapping("gerarRelatorio")
    public Relatorio gerarRelatorio() {
        return gerarRelatorio.gerarRelatorio();
    }
}
