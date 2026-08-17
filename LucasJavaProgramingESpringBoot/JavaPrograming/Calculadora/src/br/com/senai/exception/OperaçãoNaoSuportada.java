package br.com.senai.exception;

public class OperaçãoNaoSuportada extends RuntimeException {
    public OperaçãoNaoSuportada(String message) {
        super(message);
    }
}
