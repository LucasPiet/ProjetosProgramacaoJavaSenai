package br.com.senai.autoescolas164.aplication.core.spec;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrucao.DadosAgendamento;
import br.com.senai.autoescolas164.aplication.port.out.InstucaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidadorDisponibilidadeInstrutor implements ValidadorAgendamento{
    private final InstucaoRepository repository;

    @Override
    public void validar(DadosAgendamento dados){
        boolean ocupado = repository.existsByInstrutorIdAndDataHora(dados.idIsntrutor(),dados.dataHora());

    }
}
