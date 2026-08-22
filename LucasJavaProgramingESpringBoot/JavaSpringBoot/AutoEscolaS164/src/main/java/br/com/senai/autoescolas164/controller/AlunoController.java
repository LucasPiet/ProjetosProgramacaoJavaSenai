package br.com.senai.autoescolas164.controller;

import br.com.senai.autoescolas164.domain.aluno.*;
import br.com.senai.autoescolas164.domain.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescolas164.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoAluno> cadastraAluno
            (@RequestBody @Valid DadosCadastroAluno dados,
             UriComponentsBuilder uriBuilder){
        DadosDetalhamentoAluno dto = service.cadastrarAluno(dados);
        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Page<DadosListagemAluno>> listarAlunos(
            @PageableDefault ( size = 10, sort = "nome")
            Pageable paginacao){
        return ResponseEntity.ok(service.ListarAluno(paginacao));
    }
    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoAluno> atualizarAluno (@RequestBody @Valid DadosAtualizacaoAluno dados){
        return  ResponseEntity.ok(service.atualizarAluno(dados));
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoAluno> detalharAluno(@PathVariable Long id) {
        return ResponseEntity.ok(service.detalharAluno(id));

    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> excluirAluno (@PathVariable Long id){
       service.excluirAluno(id);
        return ResponseEntity.noContent().build();
    }
}
