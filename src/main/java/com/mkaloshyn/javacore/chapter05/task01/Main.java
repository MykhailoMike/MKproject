package main.java.com.mkaloshyn.javacore.chapter05.task01;

public class Main {

    public static void main(String[] args) {

        Foo foo = new Foo();

        Bar1 bar1 = new Bar1(foo);
        Bar2 bar2 = new Bar2(foo);
        Bar3 bar3 = new Bar3(foo);

        Thread thread1 = new Thread(bar1);
        Thread thread2 = new Thread(bar2);
        Thread thread3 = new Thread(bar3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Bar1 implements Runnable {

    private Foo foo;

    public Bar1(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            foo.first();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Bar2 implements Runnable {

    private Foo foo;

    public Bar2(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            foo.second();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Bar3 implements Runnable {

    private Foo foo;

    public Bar3(Foo foo) {
        this.foo = foo;
    }

    @Override
    public void run() {
        try {
            foo.third();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
