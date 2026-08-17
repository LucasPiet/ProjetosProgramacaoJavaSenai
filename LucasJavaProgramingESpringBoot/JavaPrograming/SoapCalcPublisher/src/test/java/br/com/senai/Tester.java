package br.com.senai;

import br.com.senai.service.Division;


public class Tester {

    public static void main (String[] args){
        Division sum  = new Division();
        int n1 = 230;
        int n2 = 23;

        int r = sum.calculate(n1, n2);
        System.out.println(sum.showResult(n1,n2,r));


    }
}
