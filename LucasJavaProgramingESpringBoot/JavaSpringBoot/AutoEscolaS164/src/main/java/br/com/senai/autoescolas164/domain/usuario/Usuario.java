package br.com.senai.autoescolas164.domain.usuario;

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

@Entity(name = "Usuario")
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue()
    private long id;
    private String login;
    private String senha;
    private boolean ativo = true;

    @Enumerated(EnumType.STRING)
    private Role perfil = Role.valueOf("USER");

    public Usuario(@Valid DadosCadastroUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
    }

    public Usuario(@NotNull String login, @NotBlank String senha) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil.name()));
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        UserDetails.super.isEnabled();
        return true;
    }


    public void atualizarPerfil(@Valid DadosAtualizarPerfilUsuario dados) {
        if (dados.perfil() != null) {
            this.perfil = dados.perfil();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public void atualizarSenha(Long id, String senha) {
        if (senha != null && !senha.isBlank()) {
            this.senha = senha;
        }
    }
}