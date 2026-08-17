package br.com.senai.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT )
public interface Operation {

    @WebMethod
    String operationName ();
    @WebMethod
    String operationSymbol();
    @WebMethod
    int calculate(int num1, int num2);
    @WebMethod
    String showResult(int num1, int num2, int result);
}