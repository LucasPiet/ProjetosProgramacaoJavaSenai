package br.com.senai.cadastroamigos.controller;

import br.com.senai.cadastroamigos.Amigo.Amigo;
import br.com.senai.cadastroamigos.Amigo.DadosCadastroAmigo;
import br.com.senai.cadastroamigos.Amigo.DadosDetalhamentoAmigo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/amigos")
public class amigoController {
    @PostMapping
    public ResponseEntity cadastrarAmigos (DadosCadastroAmigo dados){
        Amigo amigo = new Amigo(
                1,
                dados.nome(),
                dados.email(),
                dados.telefone()
        );
        System.out.println(amigo);
        return ResponseEntity.ok(new DadosDetalhamentoAmigo(amigo));
    }

}
