package br.com.senai.service;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.com.senai.service.Operation")
public class Resto implements Operation {


    @Override
    public String operationName() {
        return "RESTO";
    }

    @Override
    public String operationSymbol() {
        return "%";
    }

    @Override
    public int calculate(int num1, int num2) {
        return num1%num2;
    }

    @Override
    public String showResult(int num1, int num2, int result) {
        return "O RESULTADO DA " + operationName() + " Entre " + num1 + " e " + num2 + " e " + result + ".";
    }
}