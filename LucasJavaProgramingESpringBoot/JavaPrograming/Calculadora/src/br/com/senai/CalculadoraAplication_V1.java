package br.com.senai;

import java.util.Scanner;

public class CalculadoraAplication_V1 {


    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  res = "sim";
        double valor1=0, valor2=0;
        char operacao;
        System.out.println("Bem vindo a melhor calculadora do mundo!!!");
        do {
            try {

            System.out.println("Qual operação deseja fazer ?"+"\n + para soma"+"\n- para subração"+"\n* Multiplicação"+"\n/ para divisão");
            operacao = sc. next().charAt(0);
            sc.nextLine();
            if (operacao != '+'&& operacao !='-'&& operacao !='*'&& operacao!='/') {

                throw new RuntimeException("Operação não suportada");
            }
            }catch (RuntimeException e){
                System.out.println(e.getMessage()+"Você precisa colocar o simbolo da operação");
                continue;
            }
            try {
                System.out.println("Digite o primeiro valor");
                valor1= sc.nextDouble();
                sc.nextLine();
                System.out.println("Digite o segundo valor");
                valor2 = sc.nextDouble();

            } catch (MatchException e) {
                System.out.println("Digite um valor numerico");
            }
            try {
                switch (operacao){
                    case '+' -> System.out.println("O resulta da soma é: "+(valor1+valor2));
                    case '-' -> System.out.println("O resulta da subtração é: "+(valor1-valor2));
                    case '*' -> System.out.println("O resulta da multiplicação é: "+(valor1*valor2));
                    case '/' -> System.out.println("O resulta da divisão é: "+(valor1/valor2)+"O resto é: "+(valor1%valor2));
                    default -> System.out.println("Operação não encotrada");
                }
            }catch (ArithmeticException e){
                System.out.println("Não é possivel divir por 0");
            }
            System.out.println("Gostaria de continuar?");
            res = sc.next();
            sc.nextLine();
        } while (res.equalsIgnoreCase("sim"));{
            System.out.println("Fim do Sistema");
        }
    }
}
