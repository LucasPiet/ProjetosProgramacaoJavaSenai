package br.com.senai.autoescolas164.domain.agenda.validacao;

import br.com.senai.autoescolas164.domain.agenda.DadosAgendamento;
import br.com.senai.autoescolas164.domain.agenda.InstucaoRepository;
import br.com.senai.autoescolas164.domain.agenda.ValidacaoException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ValidadorLimiteDiaroAluno implements ValidadorAgendamento{
    private final InstucaoRepository repository;

    @SneakyThrows
    @Override
    public void validar (DadosAgendamento dados){
        LocalDateTime inicio = dados.dataHora().withHour(6);
        LocalDateTime fim = dados.dataHora().withHour(21-1);
        boolean reincidencia = repository.existsByAlunoIdAndDataHoraBetween(dados.idAluno(),inicio,fim);

        if (reincidencia){
            throw new ValidacaoException("Não possivel marcar mais de uma aula por dia");
        }
    }
}
