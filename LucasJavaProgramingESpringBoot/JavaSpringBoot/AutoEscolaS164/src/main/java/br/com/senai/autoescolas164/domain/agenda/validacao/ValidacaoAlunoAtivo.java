package br.com.senai.autoescolas164.domain.agenda.validacao;

import br.com.senai.autoescolas164.domain.agenda.DadosAgendamento;
import br.com.senai.autoescolas164.domain.agenda.ValidacaoException;
import br.com.senai.autoescolas164.domain.aluno.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor

public class ValidacaoAlunoAtivo implements ValidadorAgendamento {
    private final AlunoRepository alunoRepository;
    @SneakyThrows
    @Override
    public void validar (DadosAgendamento dados) {
        if (AlunoRepository.existsByIdAndAtivoFalse(dados.idAluno())){
            throw  new ValidacaoException("Aluno Inativo, não é possivel realizar a intrução");
        }
    }
}
