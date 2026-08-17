package Sample.Animal;

public abstract class Animal extends Object{
    private String sciName;
    private String popName;
    private int lifeTime;
    private double mass;
    private String habitat;

    public abstract void born ();
    public abstract void eat ();
    public abstract void grows ();
    public abstract void reproduces ();
    public abstract void die ();

    public String getSciName() {
        return sciName;
    }

    public String getPopName() {
        return popName;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public double getMass() {
        return mass;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setSciName(String sciName) {
        this.sciName = sciName;
    }

    public void setPopName(String popName) {
        this.popName = popName;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString(){
        return "Informações do animal: "+
                "\nNome cientifico: \t\t"+sciName +
                "\nNome Popular: \t\t\t"+popName+
                "\nExpectativa de Vida: \t"+lifeTime+
                "\nExpectativa de massa: \t"+mass+
                "\nHabitat Natural: \t\t"+habitat;
    }
}



