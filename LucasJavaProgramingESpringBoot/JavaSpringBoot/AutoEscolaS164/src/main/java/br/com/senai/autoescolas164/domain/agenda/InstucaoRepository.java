package br.com.senai.autoescolas164.domain.agenda;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface InstucaoRepository extends JpaRepository <Instrucao, Long> {

    boolean existsByInstrutorIdAndDataHora(Long idInstrutor,LocalDateTime dataHora);

    boolean existsByAlunoIdAndDataHoraBetween(Long idAluno, LocalDateTime inicio,LocalDateTime fim);
}

