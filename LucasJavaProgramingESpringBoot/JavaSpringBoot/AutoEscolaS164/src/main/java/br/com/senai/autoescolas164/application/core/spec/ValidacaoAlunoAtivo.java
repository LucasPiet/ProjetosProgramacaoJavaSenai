package br.com.senai.autoescolas164.application.core.spec;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrucao.DadosAgendamento;
import br.com.senai.autoescolas164.exception.type.ValidacaoException;
import br.com.senai.autoescolas164.application.port.out.AlunoRepository;
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
        if (alunoRepository.existsByIdAndAtivoFalse(dados.idAluno())){
            throw  new ValidacaoException("Aluno Inativo, não é possivel realizar a intrução");
        }
    }
}
