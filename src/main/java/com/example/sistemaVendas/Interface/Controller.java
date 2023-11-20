package com.example.sistemaVendas.Interface;
import java.util.Date;
import java.util.List;

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
import com.example.sistemaVendas.Aplicacao.ProdutosDisponiveis_UC;
import com.example.sistemaVendas.Aplicacao.SolicitarOrcamento;
import com.example.sistemaVendas.Dominio.model.ItemEstoque;
import com.example.sistemaVendas.Dominio.model.Orcamento;
import com.example.sistemaVendas.Dominio.model.Pedido;
import com.example.sistemaVendas.Dominio.model.Produto;

@RestController
public class Controller {
    @Autowired
    private ProdutosDisponiveis_UC produtosDisponiveis_UC;
    @Autowired
    private SolicitarOrcamento solicitaOrcamento;
    @Autowired
    private EfetivarOrcamento efetivaOrcamento;

    @GetMapping("itensDisponiveis")
    @CrossOrigin("*")
    public List<ItemEstoque> itensDisponiveis() {
        return produtosDisponiveis_UC.verItens();
    }

    @GetMapping("pedidos")
    @CrossOrigin("*")
    public List<Pedido> itensPedidos(){
        return produtosDisponiveis_UC.itens();
    }

    @GetMapping("produtosDisponiveis")
    @CrossOrigin("*")
    public List<Produto> produtosDisponiveis() {
        return produtosDisponiveis_UC.verProdutos();
    }

    @GetMapping("id={id}")
    @CrossOrigin("*")
    public ItemEstoque byId(@PathVariable long id) {
        return produtosDisponiveis_UC.byId(id);
    }

    @PostMapping("solicitarOrcamento")
    @CrossOrigin("*")
    public ResponseEntity<Orcamento> solicitaOrcamento(@RequestBody Orcamento novoOrcamento)    {
        Orcamento orcamento = solicitaOrcamento.solicitarOrcamento(novoOrcamento.getId(),novoOrcamento.getData(),novoOrcamento.getNomeCliente(),novoOrcamento.getPedido());
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
            // Aqui estou usando 409 Conflict, mas você pode escolher outro status que faça sentido
            return ResponseEntity.status(HttpStatus.CONFLICT).body(orcamento);
        }
    }
    
}
