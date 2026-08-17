package br.com.senai;

import br.com.senai.exception.OperaçãoNaoSuportada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraAplication_V2 {


    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = "sim";
        double valor1 = 0, valor2 = 0;
        char operacao;
        System.out.println("Bem vindo a melhor calculadora do mundo!!!");
        do {
            try {

                System.out.println(
                        "Qual operação deseja fazer ?" +
                                "\n + para soma" +
                                "\n- para subração" +
                                "\n* Multiplicação" +
                                "\n/ para divisão");

                operacao = sc.next().charAt(0);
                sc.nextLine();
                if (operacao != '+' && operacao != '-' && operacao != '*' && operacao != '/') {

                    throw new RuntimeException("Operação não suportada");
                }

                System.out.println("Digite o primeiro valor");
                valor1 = sc.nextDouble();
                sc.nextLine();
                System.out.println("Digite o segundo valor");
                valor2 = sc.nextDouble();


                switch (operacao) {
                    case '+' -> System.out.println("O resulta da soma é: " + (valor1 + valor2));
                    case '-' -> System.out.println("O resulta da subtração é: " + (valor1 - valor2));
                    case '*' -> System.out.println("O resulta da multiplicação é: " + (valor1 * valor2));
                    case '/' ->
                            System.out.println("O resulta da divisão é: " + (valor1 / valor2) + "O resto é: " + (valor1 % valor2));
                    default -> System.out.println("Operação não encotrada");
                }

                System.out.println("Gostaria de continuar?");
                res = sc.next();
                sc.nextLine();

            } catch (OperaçãoNaoSuportada e) {
                System.out.println(e.getMessage() + "Voce precisa digitar um simbolo da operação");

            } catch (InputMismatchException e) {
                System.out.println("Você precisa colocar uma valor numerico");
            } catch (ArithmeticException e) {
                System.out.println("Não pode dividir por zero");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            while (res.equalsIgnoreCase("sim")) ;
            {
                System.out.println("Fim do Sistema");
                sc.close();
            }
        }
    }

