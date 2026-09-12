package br.com.senai.autoescolas164.adapter.in.controller.response.usuario;

import br.com.senai.autoescolas164.application.core.domain.Usuario;
import br.com.senai.autoescolas164.shared.vo.enums.Role;

public record DadosDetalhamentoUsuario(
        Long id,
        String login,
        Role perfil,
        boolean ativo


) {

    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getPerfil(),
                usuario.isAtivo()
        );

    }
}

