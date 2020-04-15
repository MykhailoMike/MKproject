package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh13IOandAplets;

public class MyClass {

    int a;
    int b;

    MyClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    MyClass(int a) {
        this(a, a);
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass(5);
        System.out.println(myClass.a);
        System.out.println(myClass.b);
    }
}
