package br.com.senai;

import java.util.Scanner;

public class Tries {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Digite uma palavar qualquer");
            String palavra = sc.nextLine();

            for (int i =0; i< palavra.length();i++){
                System.out.println(palavra.charAt(i));

            }
            System.out.println("Digite um numero qualquer");
            int num = sc.nextInt();
            System.out.println(num);

        }finally {
            System.out.println("Fim do programa");
            sc.close();

        }
    }
}
