package br.com.senai.autoescolas164.infra.exception;

import br.com.senai.autoescolas164.domain.agenda.ValidacaoException;
import br.com.senai.autoescolas164.domain.aluno.AlunoNotFoundException;
import br.com.senai.autoescolas164.domain.instrutor.InstrutorNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorGlobalErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarNotFond(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity tratarBedRequest (MethodArgumentNotValidException e){
        List <FieldError> erros = e.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosBedRequest::new).toList());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DadosExpeption> tratarErroGenerico(Exception e){
        return ResponseEntity.internalServerError().body(new DadosExpeption(e.getCause().getMessage()));
    }
    @ExceptionHandler(AlunoNotFoundException.class)
    public ResponseEntity<DadosExpeption> tratarAlunoNotFound (AlunoNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DadosExpeption(e.getMessage()));
    }
    @ExceptionHandler(InstrutorNotFoundException.class)
    public ResponseEntity<DadosExpeption> tratarInstrutorNotFound (InstrutorNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DadosExpeption(e.getMessage()));
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<DadosExpeption> tratarErrosValidacao(ValidacaoException e){
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new DadosExpeption(e.getMessage()));
    }

    private record DadosExpeption (String erro){

    }

    private record DadosBedRequest (String campo, String msg){
        public DadosBedRequest(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
