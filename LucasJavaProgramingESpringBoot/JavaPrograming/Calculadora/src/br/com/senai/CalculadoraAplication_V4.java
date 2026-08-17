package br.com.senai;


import br.com.senai.util.service;

import java.util.Scanner;

public class CalculadoraAplication_V4 {


    static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String  res = "sim";
            int valor1=0, valor2=0;
            char operacao;
            System.out.println("Bem vindo a melhor calculadora do mundo!!!");
            do {


                    System.out.println("Qual operação deseja fazer ?"+"\n + para soma"+"\n- para subração"+"\n* Multiplicação"+"\n/ para divisão");
                    operacao = sc. next().charAt(0);
                    sc.nextLine();
                    if (operacao != '+'&& operacao !='-'&& operacao !='*'&& operacao!='/') {

                        throw new RuntimeException("Operação não suportada");
                    }

                    System.out.println("Digite o primeiro valor");
                    valor1= sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o segundo valor");
                    valor2 = sc.nextInt();

                    service.realizarCalculo(operacao,valor1,valor2);


                System.out.println("Gostaria de continuar?");
                res = sc.next();
                sc.nextLine();
            } while (res.equalsIgnoreCase("sim"));{
                System.out.println("Fim do Sistema");
            }
        }
    }
