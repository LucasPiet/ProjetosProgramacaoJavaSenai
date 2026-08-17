package br.com.senai;

import br.com.senai.model.Endereco;
import br.com.senai.viacepgateway.ViaCepClient;

import java.util.Scanner;

public class RestFindZipApplication {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CEP: ");
        String cep = sc.next();

        Endereco endereco = ViaCepClient.showAddress(cep);

        System.out.println("CEP: "+ endereco.getCep());
        System.out.println("Rua: "+ endereco.getLogradouro());
        System.out.println("Bairro: "+ endereco.getBairro());
        System.out.println("Cidade: "+ endereco.getLocalidade());
        System.out.println("Estado: "+ endereco.getUf()+ " ("+endereco.getEstado()+")");

    }
}
