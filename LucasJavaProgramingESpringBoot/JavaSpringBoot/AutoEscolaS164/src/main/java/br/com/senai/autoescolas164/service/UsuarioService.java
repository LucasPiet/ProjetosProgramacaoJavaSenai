package br.com.senai.autoescolas164.service;

import br.com.senai.autoescolas164.domain.usuario.*;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

        private final UsuarioRepository repository;

        @Transactional
        public DadosDetalhamentoUsuario cadastraUsario (DadosCadastroUsuario dados){
            String hash = DadoscryptografarSenha(dados.senha());
            var usuario = new Usuario(
                    dados.login(),
                    dados.senha(hash)
            );
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
            String hash = DadoscryptografarSenha(dados.senha());
            Usuario usuario = repository.findById(dados.id()).orElseThrow(()-> new RuntimeException("Id do Usuario não localizado"));
            usuario.atualizarSenha(dados.id(),dados.senha(hash));
            Usuario salvo = repository.save(usuario);
            return new DadosDetalhamentoUsuario(salvo);
        }
        @Transactional
        public void excluirUsuario(Long id) {
            Usuario usuario = repository.findById(id).orElseThrow(()-> new RuntimeException("Id do Usuario não localizado"));
            usuario.excluir();
            repository.save(usuario);
        }
        public @Nullable DadosDetalhamentoUsuario atulizarPerfilUsuario(@Valid DadosAtualizarPerfilUsuario dados) {
            Usuario usuario = repository.findById(dados.id()).orElseThrow(()-> new RuntimeException("Id do Usuario não localizado"));
            usuario.atualizarPerfil(dados);
            Usuario salvo = repository.save(usuario);
            return new DadosDetalhamentoUsuario(salvo);
        }
        public String DadoscryptografarSenha (String senha){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hash = encoder.encode(senha);
            return hash;
        }
}

