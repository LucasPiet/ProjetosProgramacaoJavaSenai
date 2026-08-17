package Sample.Animal;

public class Cow  extends Mammal implements Terrestrial{
    @Override
    public void born() {
        System.out.println("Nasceu o Francisco");

    }

    @Override
    public void eat() {
        System.out.println("Comendo pasto");
    }

    @Override
    public void grows() {
        System.out.println("Virou um boi");
    }

    @Override
    public void reproduces() {
        System.out.println("Sexo violento");
    }

    @Override
    public void die() {
        System.out.println("Chusraco do lulda");
    }

    @Override
    public void walk() {
        System.out.println("Andado, Volta aqui vaca");
    }
}
