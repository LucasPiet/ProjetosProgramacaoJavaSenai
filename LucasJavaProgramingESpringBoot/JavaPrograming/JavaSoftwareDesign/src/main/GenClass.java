package main;

public class GenClass <Type>{
    private Type key;

    public GenClass(){

    }
    public GenClass (Type key){

        this.key = key;

    }
    public Type getKey(){

        return key;

    }
    public void setKey(Type key){

        this.key = key;

    }
}
