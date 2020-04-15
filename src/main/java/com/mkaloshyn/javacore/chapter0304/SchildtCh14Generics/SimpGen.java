package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh14Generics;

public class SimpGen {

    public static void main(String[] args) {

        TwoGen<Integer, String> tgObj = new TwoGen<Integer, String>(88, "Generics");
        tgObj.showTypes();
        int v = tgObj.getOb1();
        String s = tgObj.getOb2();
        System.out.println("Value: " + v);
        System.out.println("Value: " + s);

    }
}

class TwoGen<T, V> {

    T ob1;
    V ob2;

    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    void showTypes() {
        System.out.println("Type T: " + ob1.getClass().getName());
        System.out.println("Type V: " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }


}