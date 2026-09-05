package br.com.senai.autoescolas164.aplication.core.spec;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrucao.DadosAgendamento;
import br.com.senai.autoescolas164.exception.type.ValidacaoException;
import br.com.senai.autoescolas164.aplication.port.out.InstrutorRepository;
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
