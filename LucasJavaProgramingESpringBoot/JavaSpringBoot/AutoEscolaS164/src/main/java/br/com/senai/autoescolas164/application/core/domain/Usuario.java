package br.com.senai.autoescolas164.application.core.domain;

import br.com.senai.autoescolas164.adapter.in.controller.request.usuario.DadosAtualizarPerfilUsuario;
import br.com.senai.autoescolas164.adapter.in.controller.request.usuario.DadosCadastroUsuario;
import br.com.senai.autoescolas164.shared.vo.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Usuario {
    private long id;
    private String login;
    private String senha;
    private boolean ativo = true;


    private Role perfil = Role.valueOf("USER");

    public Usuario(@Valid DadosCadastroUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public Usuario(@NotNull String login, @NotBlank String senha) {
    }




    public void excluir() {
        this.ativo = false;
    }

    public void atualizarUsuario(Long id, String senha, String login) {
        if (senha != null && !senha.isBlank() && login != null && !login.isBlank()) {
            this.senha = senha;
            this.login = login;
        }
    }
}