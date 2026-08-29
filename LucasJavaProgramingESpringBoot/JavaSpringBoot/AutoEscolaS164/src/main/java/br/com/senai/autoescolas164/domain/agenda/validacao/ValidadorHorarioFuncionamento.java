package br.com.senai.autoescolas164.domain.agenda.validacao;

import br.com.senai.autoescolas164.domain.agenda.DadosAgendamento;
import br.com.senai.autoescolas164.domain.agenda.ValidacaoException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;


@Component

public class ValidadorHorarioFuncionamento implements ValidadorAgendamento{
   @SneakyThrows
   @Override
    public void validar(DadosAgendamento dados){
       LocalDateTime agendada = dados.dataHora();

       boolean Domingo = agendada.getDayOfWeek().equals(DayOfWeek.SUNDAY);
       boolean preAbertura = agendada.getHour() < 6;
       boolean posFechamento = agendada.getHour() > (21 - 1);

        if (Domingo || preAbertura || posFechamento){
            throw new ValidacaoException("Tentativa de agendamento fora do horario de funcionamento");
        }
   }

}
