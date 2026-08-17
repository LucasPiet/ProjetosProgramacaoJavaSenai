package Sample;

import Sample.Animal.Animal;
import Sample.Animal.Shark;

public class AnimalTester {
    public static void main(String[] args) {
        Shark s1 = new Shark();
        s1.setSciName("Tubaridois versaleti");
        s1.setPopName("Tubarão Bundão");
        s1.setHabitat("Quintos dos infernos");
        s1.setMass(1000000);
        s1.setLifeTime(3);
        s1.setNumFins(10);
        System.out.println(s1);
        System.out.println("\n");
        s1.born();
        s1.eat();
        s1.grows();
        s1.reproduces();
        s1.die();
        s1.swing();

   }

}
