package main.java.com.mkaloshyn.javacore.chapter05.task02;

import java.util.concurrent.Phaser;

public class ActionNumber implements Runnable {

    private FizzBuzz fizzBuzz;
    private Phaser phaser;

    public ActionNumber(FizzBuzz fizzBuzz, Phaser phaser) {
        this.fizzBuzz = fizzBuzz;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.register();
        int n = fizzBuzz.getN();
        for (int i = 1; i <= n; i++) {
            fizzBuzz.number(i);
            if (i != n) {
                phaser.arriveAndAwaitAdvance();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                phaser.arriveAndDeregister();
            }
        }
    }
}
