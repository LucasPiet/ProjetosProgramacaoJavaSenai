package br.com.senai.autoescolas164.adapter.in.controller.response.usuario;

import br.com.senai.autoescolas164.aplication.core.domain.Usuario;

public record DadosListagemUsuario (
        Long id,
        String login

){
    public DadosListagemUsuario (Usuario usuario){
        this(
                usuario.getId(),
                usuario.getLogin()
        );
    }
}
