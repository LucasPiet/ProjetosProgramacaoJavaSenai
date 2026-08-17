package main;

import java.util.ArrayList;
import java.util.List;

public record Register(
        String sciName,
        String popName,
        int lifeTime,
        double mass,
        List<String>habitat
        ) {
        public Register{
            habitat = new ArrayList<>(habitat);

        }
    @Override
    public String toString (){
        return "Iformações do animal"+
                "\nNome Cientifico: "+sciName+
                "\nNome Popular: "+popName+
                "\nTempo de Vida: "+lifeTime+
                "\nExpectativa de massa: "+mass+
                "\n Lugares que habitam:"+habitat;
    }




}