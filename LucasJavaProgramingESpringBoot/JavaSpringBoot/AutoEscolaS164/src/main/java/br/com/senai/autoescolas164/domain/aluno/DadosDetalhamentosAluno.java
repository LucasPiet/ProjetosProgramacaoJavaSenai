package br.com.senai.autoescolas164.domain.aluno;

import br.com.senai.autoescolas164.domain.endereco.Endereco;

public record DadosDetalhamentosAluno(
        Long id,
        String nome,
        String email,
        String Telefone,
        String cpf,
        Endereco endereco
) {
    public DadosDetalhamentosAluno (Aluno aluno){
        this(
                aluno.getId(),
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getTelefone(),
                aluno.getCpf(),
                aluno.getEndereco()

        );
    }
}
