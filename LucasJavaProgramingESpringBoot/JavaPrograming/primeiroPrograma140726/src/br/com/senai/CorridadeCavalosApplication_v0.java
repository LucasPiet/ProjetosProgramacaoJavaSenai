package br.com.senai;

import java.util.Scanner;

public class CorridadeCavalosApplication_v0 {
    public static void main(String[] args) {
        //Corrida de cavalos com oito participantes e um apostador
        //Definir o comprimento da pista ( da largada até a linha de chegada ) de 100 umc
        // Os cavalos se movem a cada umt, uma distância aleatóroa de 0 a 5 umc.
        // Vence o cavalo que cruzar a linha de chegada primeiro
        // Apresentar o resultado do jogo


        // Recursos
        Scanner sc = new Scanner(System.in);
        // Saudação
        System.out.println();
        System.out.println("Bem vindo ao jogo Corrida de cavalos da Turma N-069");
        System.out.println();


        // Aposta
        System.out.println("Escolha um cavalo com valor de 1 a 8 !");
        int opcao = sc.nextInt();

        while ( opcao < 1 || opcao >8){
            System.out.println(" Digite um valor de 1 a 8");
            opcao = sc.nextInt();
            sc.nextLine();
        }
        sc.nextLine();// Para limpar o (\n) do buffer
        System.out.println(" Você escolheu o cavalo " + opcao + ". Boa sorte !");

        //System.out.println(" Pressione \"enter\" para continuar....");

        //sc.nextLine();

        // Comportamento do cavalo
        int tempo = 0;
        int posCavalo1 = 0;
        int posCavalo2 = 0;
        int posCavalo3 = 0;
        int posCavalo4 = 0;
        int posCavalo5 = 0;
        int posCavalo6 = 0;
        int posCavalo7 = 0;
        int posCavalo8 = 0;

        while (posCavalo1 < 100 &&
                posCavalo2 < 100 &&
                posCavalo3 < 100 &&
                posCavalo4 < 100 &&
                posCavalo5 < 100 &&
                posCavalo6 < 100 &&
                posCavalo7 < 100 &&
                posCavalo8 < 100) {


            tempo++;
            posCavalo1 += Math.random() * 6;
            System.out.println(" A posição do cavalo 1  é " + posCavalo1);
            posCavalo2 += Math.random() * 6;
            System.out.println(" A posição do cavalo 2  é " + posCavalo2);
            posCavalo3 += Math.random() * 6;
            System.out.println(" A posição do cavalo 3  é " + posCavalo3);
            posCavalo4 += Math.random() * 6;
            System.out.println(" A posição do cavalo 4  é " + posCavalo4);
            posCavalo5 += Math.random() * 6;
            System.out.println(" A posição do cavalo 5  é " + posCavalo5);
            posCavalo6 += Math.random() * 6;
            System.out.println(" A posição do cavalo 6  é " + posCavalo6);
            posCavalo7 += Math.random() * 6;
            System.out.println(" A posição do cavalo 7  é " + posCavalo7);
            posCavalo8 += Math.random() * 6;
            System.out.println(" A posição do cavalo 8  é " + posCavalo8);


            if (tempo == 10) {
                System.out.println("Gostaria de mudar sua aposta ? (sim/não) ");
                String resposta = sc.next();
                sc.nextLine(); // Para limpar (\n) do buffer
                if (resposta.equalsIgnoreCase("sim")) { //para ignorar se é maiuc/minusc
                    // Aposta
                    System.out.println("Escolha um cavalo com valor de 1 a 8 !");
                    opcao = sc.nextInt();
                    sc.nextLine();// Para limpar o (\n) do buffer
                    System.out.println(" Você escolheu o cavalo " + opcao + ". Boa sorte !");

                    //System.out.println(" Pressione \"enter\" para continuar....");

                    sc.nextLine();
                }
            }
            if
                    (posCavalo1 < 100 &&
                    posCavalo2 < 100 &&
                    posCavalo3 < 100 &&
                    posCavalo4 < 100 &&
                    posCavalo5 < 100 &&
                    posCavalo6 < 100 &&
                    posCavalo7 < 100 &&
                    posCavalo8 < 100) {

                    //System.out.println(" Pressione \"enter\" para continuar....");
                    //sc.nextLine();

                    try{

                        Thread.sleep(  1000);
                    }
                        catch (InterruptedException e) {
                            Thread.currentThread();
                        }
                    System.out.println();
                }

                // Finalização

                System.out.println("Fim de Jogo !");
            }
        }}
