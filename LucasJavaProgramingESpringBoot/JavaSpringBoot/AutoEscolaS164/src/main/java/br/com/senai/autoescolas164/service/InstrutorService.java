package br.com.senai.autoescolas164.service;

import br.com.senai.autoescolas164.domain.instrutor.*;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InstrutorService {
    private final InstrutorRepository repository;

    @Transactional
    public DadosDetalhamentoInstrutor cadastraInstrutor (DadosCadastroInstrutor dados){
        var instrutor = new Instrutor(dados);
        Instrutor salve = repository.save(instrutor);
        return new DadosDetalhamentoInstrutor(salve);
    }
    @Transactional(readOnly = true)
    public Page<DadosListagemInstrutor> ListarInstrutores(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(DadosListagemInstrutor::new);

    }
    @Transactional(readOnly = true)
    public @Nullable DadosDetalhamentoInstrutor detalharInstrutor(Long id) {
        Instrutor instrutor = repository.findById(id).orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        return new DadosDetalhamentoInstrutor(instrutor);

    }
    @Transactional
    public @Nullable DadosDetalhamentoInstrutor atulizarInstrutor(@Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = repository.findById(dados.id()).orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        instrutor.atualizar(dados);
        Instrutor salvo = repository.save(instrutor);
        return new DadosDetalhamentoInstrutor(salvo);
    }
    @Transactional
    public void excluirInstrutor(Long id) {
        Instrutor instrutor = repository.findById(id).orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        instrutor.excluir();
        repository.save(instrutor);
    }
}
