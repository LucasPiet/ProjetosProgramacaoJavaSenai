package br.com.senai;

import br.com.senai.service.Division;
import br.com.senai.service.Multiplication;
import br.com.senai.service.Subtract;
import br.com.senai.service.Sum;
import jakarta.xml.ws.Endpoint;

public class SoapCalcPublisherApplication {

    public static void main (String[] args){
        System.out.println("Publicando WebServices ...");
        Endpoint.publish("http://localhost:8080/calculadora/soma", new Sum());
        Endpoint.publish("http://localhost:8080/calculadora/subtracao", new Subtract());
        Endpoint.publish("http://localhost:8080/calculadora/divisao", new Division());
        Endpoint.publish("http://localhost:8080/calculadora/multiplicacao", new Multiplication());
        System.out.println("Publicados com sucesso...");

    }

}
