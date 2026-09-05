package br.com.senai.autoescolas164.adapter.in.controller;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescolas164.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescolas164.adapter.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescolas164.adapter.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescolas164.aplication.service.InstrutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instrutores")
@RequiredArgsConstructor
public class InstrutorController {

    private final InstrutorService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoInstrutor> cadastrarInstrutor
            (@RequestBody @Valid DadosCadastroInstrutor dados,
             UriComponentsBuilder uriBulder) {
        DadosDetalhamentoInstrutor dto = service.cadastraInstrutor(dados);
        URI uri = uriBulder
                .path("/instrutores/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @PageableDefault(size = 10, sort = "nome")
            Pageable paginacao) {
        return ResponseEntity.ok(service.ListarInstrutores(paginacao));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity <DadosDetalhamentoInstrutor> detalharInstutor(@PathVariable Long id) {
        return ResponseEntity.ok(service.detalharInstrutor(id));
        
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor
            (@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        return ResponseEntity.ok(service.atulizarInstrutor(dados));
        
        
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> excluirInstrutor(@PathVariable Long id) {
       service.excluirInstrutor(id);
        return ResponseEntity.noContent().build();
    }
}