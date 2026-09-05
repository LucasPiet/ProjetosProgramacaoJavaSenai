package br.com.senai.autoescolas164.adapter.in.controller;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrucao.DadosAgendamento;
import br.com.senai.autoescolas164.adapter.in.controller.response.instrucao.DadosDetalhamentosAgendamento;
import br.com.senai.autoescolas164.exception.type.ValidacaoException;
import br.com.senai.autoescolas164.exception.type.InstrutorNotFoundException;
import br.com.senai.autoescolas164.aplication.service.AgendaDeInstrucao;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/isntrucoes")
@RequiredArgsConstructor
public class instrucaoController {
    private final AgendaDeInstrucao agenda;


    @PostMapping
    public ResponseEntity<DadosDetalhamentosAgendamento> agendarInstrucao(
            @RequestBody @Valid DadosAgendamento dados) throws InstrutorNotFoundException, ValidacaoException {

        return ResponseEntity.ok(agenda.agendar(dados));
    }


}
