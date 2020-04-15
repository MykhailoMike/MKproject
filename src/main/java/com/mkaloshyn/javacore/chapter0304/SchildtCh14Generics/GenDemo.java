package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh14Generics;

public class GenDemo {

    public static void main(String[] args) {

        Gen<Integer> iOb;
        iOb = new Gen<Integer>(88);
        iOb.showtype();
        int v = iOb.getOb();
        System.out.println("Value is: " + v);
        System.out.println();

        Gen<String> sOb;
        sOb = new Gen<String>("This is text");
        sOb.showtype();
        String s = sOb.getOb();
        System.out.println("Value is: " + s);

    }
}

class Gen<T> {
    T ob;

    Gen (T o) {
        this.ob = o;
    }

    T getOb() {
        return ob;
    }

    void showtype() {
        System.out.println("Type T is : " + ob.getClass().getName());
    }
}
