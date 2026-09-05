package br.com.senai.autoescolas164.adapter.in.controller.request.usuario;

import br.com.senai.autoescolas164.shared.vo.enums.Role;

public record DadosAtualizarPerfilUsuario (
        Role perfil,
        Long id
){
}
