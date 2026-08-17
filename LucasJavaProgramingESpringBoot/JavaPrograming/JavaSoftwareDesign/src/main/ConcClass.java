package main;

public class ConcClass extends AbstClass{

    public int key = 5555;
    public void sayHello (){
        System.out.println("Opa");
    }
    public void originSayHello(){
        super.sayHello();
    }

    @Override
    public void sayHi() {
        System.out.println("Hiiii");
    }


    @Override
    public void interfaceMethod2() {
        System.out.println("Hi");

    }
}
