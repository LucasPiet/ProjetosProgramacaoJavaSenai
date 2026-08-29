package br.com.senai.autoescolas164.domain.agenda;

import br.com.senai.autoescolas164.domain.instrutor.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamento (
        @NotNull
        @JsonProperty("id_aluno")
        Long idAluno,

        @JsonProperty("id_isntrutor")
        Long idIsntrutor,
        Especialidade especialidade,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/mm/yyyy - HH:mm")
        @JsonProperty("data_hora")
        LocalDateTime dataHora
) {
}
