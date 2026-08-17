package br.com.senai;

import java.util.Scanner;

public class CalculadoraAplication_V0 {


    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  res = "sim";
        double valor1=0, valor2=0;
        System.out.println("Bem vindo a melhor calculadora do mundo!!!");
        do {


            System.out.println("Qual operação deseja fazer ?"+"\n + para soma"+"\n- para subração"+"\n* Multiplicação"+"\n/ para divisão");
            char opercao = sc. next().charAt(0);
            sc.nextLine();
            if (opercao != '+'&& opercao !='-'&& opercao !='*'&& opercao!='/') {

            }

                System.out.println("Digite o primeiro valor");
                valor1= sc.nextDouble();
                sc.nextLine();
                System.out.println("Digite o segundo valor");
                valor2 = sc.nextDouble();


        } while (res.equalsIgnoreCase("sim"));{
            System.out.println();
        }
    }
}
