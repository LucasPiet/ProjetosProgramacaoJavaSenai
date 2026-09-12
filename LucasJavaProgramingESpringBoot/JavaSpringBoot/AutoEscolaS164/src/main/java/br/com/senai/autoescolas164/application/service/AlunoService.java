package br.com.senai.autoescolas164.application.service;

import br.com.senai.autoescolas164.adapter.in.controller.mapper.AlunoMapper;
import br.com.senai.autoescolas164.adapter.in.controller.request.aluno.DadosAtualizacaoAluno;
import br.com.senai.autoescolas164.adapter.in.controller.request.aluno.DadosCadastroAluno;
import br.com.senai.autoescolas164.adapter.in.controller.response.aluno.DadosDetalhamentoAluno;
import br.com.senai.autoescolas164.adapter.in.controller.response.aluno.DadosListagemAluno;
import br.com.senai.autoescolas164.application.core.domain.Aluno;
import br.com.senai.autoescolas164.application.port.out.AlunoRepository;
import br.com.senai.autoescolas164.shared.vo.endereco.mapper.EnderecoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository repository;
    public final AlunoMapper mapper;
    public EnderecoMapper enderecoMapper;

    @Transactional
    public DadosDetalhamentoAluno cadastrarAluno(@Valid DadosCadastroAluno dados) {
        Aluno aluno = mapper.toDomain(dados);
        Aluno salve = repository.save(aluno);
        return mapper.toDetailDto(salve);

    }
    @Transactional(readOnly = true)
    public Page<DadosListagemAluno> ListarAluno(Pageable paginacao) {
        return repository
                .findAllByAtivoTrue(paginacao)
                .map(mapper::toListDto);
    }

    @Transactional
    public DadosDetalhamentoAluno atualizarAluno(@Valid DadosAtualizacaoAluno dados) {
       Aluno aluno = repository.findById(dados.id())
               .orElseThrow(()-> new RuntimeException("ID do aluno informado não existe"));
       aluno.atualizar(
               dados.nome(),
               dados.email(),
               dados.telefone(),
               enderecoMapper.toEndereco(dados.endereco())
       );
       Aluno salve = repository.save(aluno);
       return mapper.toDetailDto(salve);
    }
    @Transactional(readOnly = true)
    public DadosDetalhamentoAluno detalharAluno(Long id) {
        Aluno aluno = repository.findById(id).
                orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        return mapper.toDetailDto(aluno);
    }
    @Transactional
    public void excluirAluno(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Id do Instrutor não localizado"));
        aluno.excluir();
        repository.save(aluno);
    }
}
