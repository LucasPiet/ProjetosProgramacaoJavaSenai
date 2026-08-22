package br.com.senai.autoescolas164.service;

import br.com.senai.autoescolas164.domain.usuario.*;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class UsuarioService {
    @RequiredArgsConstructor
    @Service
    public class InstrutorService {
        private final UsuarioRepository repository;

        @Transactional
        public DadosDetalhamentoUsuario cadastraInstrutor (DadosCadastroUsuario dados){
            var usuario = new Usuario(dados);
            Usuario salve = repository.save(usuario);
            return new DadosDetalhamentoUsuario(salve);
        }
        @Transactional(readOnly = true)
        public Page<DadosListagemUsuario> ListarUsuario(Pageable paginacao) {
            return repository
                    .findAll(paginacao)
                    .map(DadosListagemUsuario::new);

        }
        @Transactional(readOnly = true)
        public @Nullable DadosDetalhamentoUsuario detalharUsuario(Long id) {
            Usuario usuario = repository.findById(id).orElseThrow(()-> new RuntimeException("Id do usuario não localizado"));
            return new DadosDetalhamentoUsuario(usuario);

        }
        @Transactional
        public @Nullable DadosDetalhamentoUsuario atulizarSenhaUsuario(@Valid DadosAtualizarSenhaUsuario dados) {
            Usuario usuario = repository.findById(dados.id()).orElseThrow(()-> new RuntimeException("Id do Usuario não localizado"));
            usuario.atualizar(dados);
            Usuario salvo = repository.save(usuario);
            return new DadosDetalhamentoUsuario(salvo);
        }
        @Transactional
        public void excluirUsuario(Long id) {
            Usuario usuario = repository.findById(id).orElseThrow(()-> new RuntimeException("Id do Usuario não localizado"));
            usuario.excluir();
            repository.save(usuario);
        }
        public @Nullable DadosDetalhamentoUsuario atulizarPerfilUsuario(@Valid DadosAtualizarSenhaUsuario dados) {
            Usuario usuario = repository.findById(dados.id()).orElseThrow(()-> new RuntimeException("Id do Usuario não localizado"));
            usuario.atualizar(dados);
            Usuario salvo = repository.save(usuario);
            return new DadosDetalhamentoUsuario(salvo);
        }
    }
}
