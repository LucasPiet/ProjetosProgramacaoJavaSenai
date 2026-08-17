package br.com.senai.autoescolas164.controller;

import br.com.senai.autoescolas164.domain.instrutor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor> cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados, UriComponentsBuilder uriBulder) {
        var instrutor = new Instrutor(dados);
        Instrutor salve = repository.save(instrutor);
        var dto = new DadosDetalhamentoInstrutor(salve);
        URI uri = uriBulder.path("/instrutores/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @PageableDefault(size = 10, sort = "nome")
            Pageable paginacao) {
        Page page = repository
                .findAll(paginacao)
                .map(DadosListagemInstrutor::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public DadosDetalhamentoInstrutor detalharInstutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        return new DadosDetalhamentoInstrutor(instrutor);
        
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizar(dados);
        Instrutor salvo = repository.save(instrutor);
        var dto = new DadosDetalhamentoInstrutor(salvo);
        return ResponseEntity.ok(dto);
        
        
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirInstrutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        repository.save(instrutor);
        return ResponseEntity.noContent().build();
    }
}