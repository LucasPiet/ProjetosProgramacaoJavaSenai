package br.com.senai.autoescolas164.adapter.in.controller;

import br.com.senai.autoescolas164.adapter.in.controller.request.usuario.DadosAtualizarPerfilUsuario;
import br.com.senai.autoescolas164.adapter.in.controller.request.usuario.DadosAtualizarSenhaUsuario;
import br.com.senai.autoescolas164.adapter.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senai.autoescolas164.adapter.in.controller.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescolas164.adapter.in.controller.response.usuario.DadosListagemUsuario;
import br.com.senai.autoescolas164.application.service.UsuarioService;
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
@RequestMapping("/Usuario")
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

    @PutMapping("/senha")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DadosDetalhamentoUsuario> atualizaSenharUsuario
            (@RequestBody @Valid DadosAtualizarSenhaUsuario dados) {
        return ResponseEntity.ok(service.atulizarSenhaUsuario(dados));


    }
    @PutMapping("/perfil")
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