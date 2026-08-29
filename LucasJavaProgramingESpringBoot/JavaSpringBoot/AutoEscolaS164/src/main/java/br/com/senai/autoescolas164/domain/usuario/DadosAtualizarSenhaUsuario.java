package br.com.senai.autoescolas164.domain.usuario;

public record DadosAtualizarSenhaUsuario(
        Long id,
        String senha
) {
    public String senha(String hash) {
        return hash;
    }
}
