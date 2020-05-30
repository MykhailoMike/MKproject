package main.java.com.mkaloshyn.javacore.chapter05.habr;

public class Ship {
    private int loading;
    private Size size;
    private Type type;

    public Ship(Type type, Size size) {
        this.type = type;
        this.size = size;
    }

    public void add(int amount) {
        this.loading += amount;
    }

    public boolean loadingCheck() {
        return loading < size.getValue();
    }

    public int getLoading() {
        return loading;
    }

    public Size getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }
}

enum Type {
    DRESS, BANANA, MEAL;
}

enum Size {
    S(10), M(50), L(100);

    private int value;

    private Size(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
