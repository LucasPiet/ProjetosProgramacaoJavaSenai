package Sample.Animal;

public class Shark  extends Fish{

    private int numFins;

    public int getNumFins() {
        return numFins;
    }

    public void setNumFins(int numFins) {
        this.numFins = numFins;
    }

    @Override
    public void born() {
        System.out.println("Tubarão Nasceu");
    }

    @Override
    public void eat() {
        System.out.println("Tubarão Comendo!! Nhac !!");
    }

    @Override
    public void grows() {
        System.out.println("Tubarão Crescendo");
    }

    @Override
    public void reproduces() {
        System.out.println("Sexo hummm");

    }

    @Override
    public void die() {
        System.out.println("No ceu tem pao e morreu");
    }

    @Override
    public void swing() {
        System.out.println("Nadando");
    }
}
