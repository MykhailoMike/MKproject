package main.java.com.mkaloshyn.javacore.chapter05.task01;

import java.util.concurrent.Semaphore;

public class Foo {

    private Semaphore semFirst = new Semaphore(1);
    private Semaphore semSecond = new Semaphore(0);
    private Semaphore semThird = new Semaphore(0);

    public void first() throws InterruptedException {
        semFirst.acquire();
        print("first");
        semSecond.release();
    }

    public void second() throws InterruptedException {
        semSecond.acquire();
        print("second");
        semThird.release();
    }

    public void third() throws InterruptedException {
        semThird.acquire();
        print("third");
    }

    public void print(String str) {
        System.out.print(str);
    }

}
