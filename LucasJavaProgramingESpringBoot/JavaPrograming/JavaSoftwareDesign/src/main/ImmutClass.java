package main;

import java.util.ArrayList;
import java.util.List;

public final class ImmutClass {

    private final String sciName;
    private final String popName;
    private final int lifeTime;
    private final double mass;
    private final List<String> habitat;

    public ImmutClass(
        String sciName,
        String popName,
        int lifeTime,
        double mass,
        List<String> habitat
        ){
        this.sciName = sciName;
        this.popName = popName;
        this.habitat = new ArrayList<>(habitat);
        this.mass = mass;
        this.lifeTime = lifeTime;


    }

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

    public List<String> getHabitat() {
        return habitat;
    }
    public String toString (){
        return "Iformações do animal"+
                "\nNome Cientifico: "+sciName+
                "\nNome Popular: "+popName+
                "\nTempo de Vida: "+lifeTime+
                "\nExpectativa de massa: "+mass+
                "\n Lugares que habitam:"+habitat;
    }
}
