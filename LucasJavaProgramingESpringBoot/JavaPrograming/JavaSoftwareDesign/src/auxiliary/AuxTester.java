package auxiliary;

//import main.ConcClass1;
import main.*;


public class AuxTester {
    public static void main(String[] args) {
//        ConcClass1 cc1 = new ConcClass1();
//        ConcClass2 cc2 = new ConcClass2();
//        System.out.println(cc2.getChave());
//        AbstClass ac = new ConcClass();
//        System.out.println(ac.key);
//        AuxClass aux = new AuxClass();
//        System.out.println(aux.INTERFACE_VAR);
//        aux.intefaceMethod1();
//
//
//
//        Enumeration test = Enumeration.ENUM_OBJECT_1;
//        System.out.println(test.getValue1());
//        test.value1 = 100;
//        System.out.println(test.value1);
//        System.out.println(test.getValue2());
        GenClass gc1 = new GenClass();
        System.out.println(gc1.getKey());
        gc1.setKey(456);
        System.out.println(gc1.getKey());
        gc1.setKey("Senha");
        System.out.println(gc1.getKey());

        GenClass<String> gc2 =  new GenClass<>();
        gc2.setKey("SENHA");
        System.out.println(gc2.getKey());

        GenClass<Integer> gc3 = new GenClass<>();
        GenClass2<Integer,String> gc4 = new GenClass2<>();

        gc4.setKey(777);
        gc4.setDescription("Texto qualquer");
        System.out.println(gc4.getKey());
        System.out.println(gc4.getDescription());
        Tools.showInfo("ELE FUNCIONA");
        boolean bool = true;
        Tools.showInfo(bool);
    }
}