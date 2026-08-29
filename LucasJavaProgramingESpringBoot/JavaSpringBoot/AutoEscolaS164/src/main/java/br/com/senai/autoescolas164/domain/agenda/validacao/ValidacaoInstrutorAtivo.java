package br.com.senai.autoescolas164.domain.agenda.validacao;

import br.com.senai.autoescolas164.domain.agenda.DadosAgendamento;
import br.com.senai.autoescolas164.domain.agenda.ValidacaoException;
import br.com.senai.autoescolas164.domain.instrutor.InstrutorRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidacaoInstrutorAtivo implements ValidadorAgendamento {
    private final InstrutorRepository instrutorRepository;


@SneakyThrows
@Override
    public void validar(DadosAgendamento dados) {
        if (instrutorRepository.existsByIdAndAtivoFalse(dados.idIsntrutor())){
            throw  new ValidacaoException("Instrutor Inativo, não é possivel realizar a intrução");
        }
    }

}
