package br.com.senai.autoescolas164.service;

import br.com.senai.autoescolas164.domain.aluno.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;

@RequiredArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository repository;

    @Transactional
    public DadosDetalhamentoAluno cadastrarAluno(@Valid DadosCadastroAluno dados) {
        var aluno = new Aluno(dados);
        Aluno salve = repository.save(aluno);
        return new DadosDetalhamentoAluno(salve);

    }
    @Transactional(readOnly = true)
    public Page<DadosListagemAluno> ListarAluno(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(DadosListagemAluno::new);
    }

    @Transactional
    public DadosDetalhamentoAluno atualizarAluno(@Valid DadosAtualizacaoAluno dados) {
        Aluno aluno = repository.findById(dados.id()).orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        aluno.atualizar(dados);
        Aluno salve = repository.save(aluno);
       return new DadosDetalhamentoAluno(salve);
    }
    @Transactional(readOnly = true)
    public DadosDetalhamentoAluno detalharAluno(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        return new DadosDetalhamentoAluno(aluno);
    }
    @Transactional
    public void excluirAluno(Long id) {
        Aluno aluno = repository.findById(id).orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        aluno.excluir();
        repository.save(aluno);
    }
}
