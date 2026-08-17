package main;

import java.util.Optional;

public class MainTester {
    public static void main(String[] args) {

//        // Roteiro 1
//        ConcClass1 cc1 = new ConcClass1();
//        ConcClass2 cc2 = new ConcClass2();
//
//        System.out.println(cc1.getChave());
//        cc1.setChave(5557);
//        System.out.println(cc1.getChave());
        // roteiro 2

        AbstClass ac = new ConcClass();
        ConcClass cc = new ConcClass();

        System.out.println(ac.key);
        ac.sayHello();
        cc.sayHello();
        cc.originSayHello();

        System.out.println(ac.INTERFACE_VAR);

        ac.intefaceMethod1();
        ac.interfaceMethod2();

//        Tools t1 = new Tools();
//        Tools t2 = new Tools();
//
//        System.out.println(t1.options);
//        System.out.println(t2.options);
//
//        t1.options = 'a';
//        t2.options = 'b';
//        System.out.println(t1.options);
//        System.out.println(t2.options);
//
//        t1.options = 'c';
//
//        System.out.println(t1.options);
//        System.out.println(t2.options);
        Tools.options = 'z';
        Tools.printOptions();
        Tools.options = 'a';
        Tools.printOptions();
        Tools.display(1.011);
        Tools.display("Ola");
        Tools.display(1,2);
        Tools.sum(45,75);
    }
}
