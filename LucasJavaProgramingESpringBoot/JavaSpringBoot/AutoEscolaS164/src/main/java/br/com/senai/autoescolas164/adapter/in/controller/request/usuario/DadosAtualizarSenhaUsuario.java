package br.com.senai.autoescolas164.adapter.in.controller.request.usuario;

public record DadosAtualizarSenhaUsuario(
        Long id,
        String senha
) {
    public String senha(String hash) {
        return hash;
    }
}
