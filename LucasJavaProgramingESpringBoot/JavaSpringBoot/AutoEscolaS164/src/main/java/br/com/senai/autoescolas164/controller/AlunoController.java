package br.com.senai.autoescolas164.controller;

import br.com.senai.autoescolas164.domain.aluno.*;
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
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentosAluno> cadastraAluno(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        Aluno salve = repository.save(aluno);
        var dto = new DadosDetalhamentosAluno(salve);
        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<DadosListagemAluno>> listarAlunos(
            @PageableDefault ( size = 10, sort = "nome")
            Pageable paginacao){
        Page page = repository
                .findAll(paginacao)
                .map(DadosListagemAluno::new);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentosAluno> atualizarAluno (@RequestBody @Valid DadosAtualizacaoAluno dados){
        Aluno aluno = repository.getReferenceById(dados.id());
        aluno.atualizar(dados);
        Aluno salve = repository.save(aluno);
        var dto = new DadosDetalhamentosAluno(salve);
        return  ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirAluno (@PathVariable Long id){
        Aluno aluno = repository.getReferenceById(id);
        aluno.excluir();
        Aluno salve = repository.save(aluno);
        return ResponseEntity.noContent().build();
    }
}
