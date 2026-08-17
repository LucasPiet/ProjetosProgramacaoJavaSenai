package br.com.senai.autoescolas164.domain.aluno;

import br.com.senai.autoescolas164.domain.endereco.DadosEndereco;
import jakarta.validation.*;
import jakarta.validation.constraints.*;


public record DadosCadastroAluno(
    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String telefone,

    @NotBlank
    @Pattern(regexp = "\\d{11}")
    String cpf,

    @Valid
    DadosEndereco endereco
){

}
