package main;

public interface interface1 {

    boolean INTERFACE_VAR = true;

    default void intefaceMethod1(){
        System.out.println("Metedo Implemtado!!");
        interfaceMethod3();
    }
    void interfaceMethod2 ();

    private void interfaceMethod3(){
        System.out.println(" ta podendo cagar?????");
    }
}
