package br.com.senai.autoescolas164.application.service;

import br.com.senai.autoescolas164.adapter.in.controller.request.instrucao.DadosAgendamento;
import br.com.senai.autoescolas164.adapter.in.controller.response.instrucao.DadosDetalhamentosAgendamento;
import br.com.senai.autoescolas164.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescolas164.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescolas164.application.core.domain.Instrucao;
import br.com.senai.autoescolas164.application.port.out.InstucaoRepository;
import br.com.senai.autoescolas164.exception.type.ValidacaoException;
import br.com.senai.autoescolas164.application.core.spec.ValidadorAgendamento;
import br.com.senai.autoescolas164.application.core.domain.Aluno;
import br.com.senai.autoescolas164.exception.type.AlunoNotFoundException;
import br.com.senai.autoescolas164.application.port.out.AlunoRepository;
import br.com.senai.autoescolas164.application.core.domain.Instrutor;
import br.com.senai.autoescolas164.exception.type.InstrutorNotFoundException;
import br.com.senai.autoescolas164.application.port.out.InstrutorRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AgendaDeInstrucao {
    private final InstucaoRepository repository;
    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;
    private final List<ValidadorAgendamento> ValidadoresAgendamento;

    public DadosDetalhamentosAgendamento agendar(@Valid DadosAgendamento dados) throws InstrutorNotFoundException, ValidacaoException {
        if(!alunoRepository.existsById(dados.idAluno())){
           throw new AlunoNotFoundException("ID do aluno informado não existe");
        }
        if(dados.idIsntrutor() != null && !instrutorRepository.existsById(dados.idIsntrutor())){
            throw new InstrutorNotFoundException("ID do instrutor nao exite");
        }
        //Validações
        ValidadoresAgendamento.forEach(validador -> validador.validar(dados));

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());
        Instrutor instrutor = escolherInstrutor(dados);
        if (instrutor == null){
            throw new ValidacaoException("Não existe instrutor disponivel para data/hora informada");
        }
    Instrucao instrucao = new Instrucao(
            null,
            aluno,
            instrutor,
            dados.dataHora()
    );
    Instrucao salve = repository.save(instrucao);
    return new DadosDetalhamentosAgendamento (salve);
    }

    private Instrutor escolherInstrutor(@Valid DadosAgendamento dados) throws ValidacaoException {
        if (dados.idIsntrutor() != null){
           return instrutorRepository.getReferenceById(dados.idIsntrutor());
        }
        if (dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é campo obrigatorio, caso o instrutor não for informado ");
        }
        return instrutorRepository.escolherInstrutorAleatorioDisponivel(dados.especialidade(), dados.dataHora());
    }

}
