package br.com.senai.autoescolas164.domain.usuario;

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
