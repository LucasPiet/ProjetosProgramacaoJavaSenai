package br.com.senai.autoescolas164.controller;

import br.com.senai.autoescolas164.domain.usuario.DadosLogin;
import br.com.senai.autoescolas164.domain.usuario.Usuario;
import br.com.senai.autoescolas164.infra.security.TokenService;
import br.com.senai.autoescolas164.infra.security.dadostokenJWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class LoginController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity<dadostokenJWT> efetuarLogin(@RequestBody @Valid DadosLogin dados ){
        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        Authentication authentication = manager.authenticate(token);
        String tokenJWT = tokenService.genToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new dadostokenJWT(tokenJWT));
    }

}
