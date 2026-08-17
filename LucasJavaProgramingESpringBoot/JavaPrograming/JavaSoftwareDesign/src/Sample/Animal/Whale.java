package Sample.Animal;

public class Whale extends Mammal implements Aquatic {


    @Override
    public void born() {
        System.out.println("Baleia nascendo");
    }

    @Override
    public void eat() {
        System.out.println("Baleia Comendo");

    }

    @Override
    public void grows() {
        System.out.println("Baleia Crescendo");
    }

    @Override
    public void reproduces() {
        System.out.println("Sexxooo");

    }

    @Override
    public void die() {
        System.out.println("Morreu!!!!");
    }

    @Override
    public void swing() {
        System.out.println("Continue a nadar");
    }
}
