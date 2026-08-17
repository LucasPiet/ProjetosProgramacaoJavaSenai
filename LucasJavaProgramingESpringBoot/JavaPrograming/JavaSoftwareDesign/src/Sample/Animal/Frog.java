package Sample.Animal;

public class Frog extends Amphibian{
    @Override
    public void born() {
        System.out.println("Olha o girino ai");
    }

    @Override
    public void eat() {
        System.out.println("Mosca webet");
    }

    @Override
    public void grows() {
        System.out.println("Crazy frog tuts tuts");
    }

    @Override
    public void reproduces() {
        System.out.println("Sexo");
    }

    @Override
    public void die() {
        System.out.println("Sopa de sapo");
    }

    @Override
    public void swing() {
        System.out.println("nadando");
    }

    @Override
    public void walk() {
        System.out.println("Pulando");
    }
}
