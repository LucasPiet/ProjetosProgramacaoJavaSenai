package br.com.senai.autoescolas164.domain.agenda.validacao;

import br.com.senai.autoescolas164.domain.agenda.DadosAgendamento;
import br.com.senai.autoescolas164.domain.agenda.InstucaoRepository;
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
