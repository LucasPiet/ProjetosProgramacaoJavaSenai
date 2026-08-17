package main;

public class Tools {

    public static char options = '-';
    public char alternative = 'e';

    public static void printOptions(){
        char altern = 'a';
        System.out.println(altern);
        System.out.println(options);
    }
    public void printAlternative (){
        char altern = 'n';
        System.out.println(altern);
        System.out.println(alternative);
    }
    public void printOp (){
        System.out.println(options);
    }
    public static void display (String str){
        System.out.println(str);
    }
    public static void display (double dbl){
        System.out.println(dbl);
    }
    public static void display (int n1, int n2){
        System.out.println(""+n1+n2);
    }
    public static double sum (double n1, double n2){
        double result = n1 + n2;
        System.out.println("A Soma do Numero 1: "+n1+" + "+"Numero 2: "+n2+" o resultado é: "+result);
        return result;
    }
    //Metodo generico
    @Annotation1("Valor", value = 1)
    public static <T> void showInfo(T info){
        System.out.println("Info:" + info);

    }

}

