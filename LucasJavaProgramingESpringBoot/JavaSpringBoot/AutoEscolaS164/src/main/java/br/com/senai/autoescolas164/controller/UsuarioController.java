package br.com.senai.autoescolas164.controller;

import br.com.senai.autoescolas164.domain.usuario.*;
import br.com.senai.autoescolas164.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario
            (@RequestBody @Valid DadosCadastroUsuario dados,
             UriComponentsBuilder uriBulder) {
        DadosDetalhamentoUsuario dto = service.cadastraUsario(dados);
        URI uri = uriBulder
                .path("/Usuario/{id}")
                .buildAndExpand(dto.id())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<Page<DadosListagemUsuario>> listarUsuarios(
            @PageableDefault(size = 10, sort = "nome")
            Pageable paginacao) {
        return ResponseEntity.ok(service.ListarUsuario(paginacao));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity <DadosDetalhamentoUsuario> detalharUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(service.detalharUsuario(id));

    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoUsuario> atualizaSenharUsuario
            (@RequestBody @Valid DadosAtualizarSenhaUsuario dados) {
        return ResponseEntity.ok(service.atulizarSenhaUsuario(dados));


    }
    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoUsuario> atualizaPerfilUsuario
            (@RequestBody @Valid DadosAtualizarPerfilUsuario dados) {
        return ResponseEntity.ok(service.atulizarPerfilUsuario(dados));


    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        service.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}