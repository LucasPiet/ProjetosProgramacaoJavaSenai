package br.com.senai.autoescolas164.aplication.service;

import br.com.senai.autoescolas164.adapter.in.controller.mapper.InstrutorMapper;
import br.com.senai.autoescolas164.adapter.in.controller.request.instrutor.DadosAtualizacaoInstrutor;
import br.com.senai.autoescolas164.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescolas164.adapter.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.senai.autoescolas164.adapter.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescolas164.aplication.core.domain.Instrutor;
import br.com.senai.autoescolas164.aplication.port.out.InstrutorRepository;
import br.com.senai.autoescolas164.shared.vo.endereco.Endereco;
import br.com.senai.autoescolas164.shared.vo.endereco.mapper.EnderecoMapper;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class InstrutorService {
    private final InstrutorRepository repository;
    private final InstrutorMapper mapper;
    private final EnderecoMapper enderecoMapper;

    @Transactional
    public DadosDetalhamentoInstrutor cadastraInstrutor (DadosCadastroInstrutor dados){
        Instrutor instrutor = mapper.toDomain(dados);
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
        instrutor.atualizar(
                dados.nome(),
                dados.email(),
                dados.telefone(),
                dados.especialidade(),
                enderecoMapper.toEndereco(dados.endereco())
        );
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
