package main;

public enum Enumeration {
    ENUM_OBJECT_1(123,"todos"),
    ENUM_OBJECT_2(456,"Nada"),
    ENUM_OBJECT_3(789,"Texto3");

    private final int value1;
    private final String value2;

    private Enumeration(int value1, String value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }
}
