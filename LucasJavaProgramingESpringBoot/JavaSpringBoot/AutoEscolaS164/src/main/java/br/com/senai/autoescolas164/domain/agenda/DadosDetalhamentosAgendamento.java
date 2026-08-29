package br.com.senai.autoescolas164.domain.agenda;

import br.com.senai.autoescolas164.domain.instrutor.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.web.JsonPath;

import java.time.LocalDateTime;

public record DadosDetalhamentosAgendamento(
        Long id,
        @JsonProperty("nome_aluno")
        String nomeAluno,
        @JsonProperty("nome_instrutor")
        String nomeInstrutor,
        Especialidade especialidade,
        @JsonProperty("data_hora")
        @JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
        LocalDateTime datahora
) {
    public DadosDetalhamentosAgendamento (Instrucao instrucao){
        this(
                instrucao.getId(),
                instrucao.getAluno().getNome(),
                instrucao.getInstrutor().getNome(),
                instrucao.getInstrutor().getEspecialidade(),
                instrucao.getDataHora()
        );
    }
}
