package br.com.senai.autoescolas164.aplication.core.domain;

import br.com.senai.autoescolas164.adapter.in.controller.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescolas164.adapter.in.controller.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescolas164.shared.vo.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity (name = "Aluno")
@Table  (name = "aluno")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private boolean ativo = true;

    @Embedded
    private Endereco endereco;


    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }



    public void excluir() {

        this.ativo = false;

    }


    public void atualizar(DadosAtualizacaoAluno dados) {
        if (dados.nome() != null && !dados.nome().isBlank()){
            this.nome = dados.nome();
        }
        if (dados.email() != null && !dados.email().isBlank()){
            this.email = dados.email();
        }
        if (dados.telefone() != null && !dados.telefone().isBlank()){
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null){
            this.endereco.atualizar(dados.endereco());
        }
    }
}
