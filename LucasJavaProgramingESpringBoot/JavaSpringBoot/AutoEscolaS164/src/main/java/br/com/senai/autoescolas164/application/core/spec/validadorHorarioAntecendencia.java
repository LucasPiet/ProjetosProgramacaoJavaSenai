package br.com.senai.autoescolas164.application.core.spec;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrucao.DadosAgendamento;
import br.com.senai.autoescolas164.exception.type.ValidacaoException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class validadorHorarioAntecendencia implements ValidadorAgendamento {
    @SneakyThrows
    @Override
    public void validar (DadosAgendamento dados){
        LocalDateTime agendada = dados.dataHora();
        LocalDateTime agora = LocalDateTime.now();

        long antecedencia = Duration.between(agora,agendada).toMinutes();

        if (antecedencia < 30){
            throw new ValidacaoException("Antecediancia minima de 30 min. para agendar");
        }
    }
}
