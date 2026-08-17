package br.com.senai.util;

public  class service {
    public static void realizarCalculo(char operacao, int valor1, int valor2) {
        try {

            switch (operacao) {
                case '+' -> System.out.println("O resulta da soma é: " + (valor1 + valor2));
                case '-' -> System.out.println("O resulta da subtração é: " + (valor1 - valor2));
                case '*' -> System.out.println("O resulta da multiplicação é: " + (valor1 * valor2));
                case '/' ->
                        System.out.println("O resulta da divisão é: " + (valor1 / valor2) + "O resto é: " + (valor1 % valor2));
                default -> System.out.println("Operação não encotrada");
            }
        }catch(ArithmeticException e){
                System.out.println("Não pode dividir por zero");
            }
        }
    }


