package main.java.com.mkaloshyn.javacore.chapter05.task02;

import java.util.concurrent.Phaser;

public class ActionBuzz implements Runnable {

    private FizzBuzz fizzBuzz;
    private Phaser phaser;

    public ActionBuzz(FizzBuzz fizzBuzz, Phaser phaser) {
        this.fizzBuzz = fizzBuzz;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.register();
        int n = fizzBuzz.getN();
        for (int i = 1; i <= n; i++) {
            fizzBuzz.buzz(i);
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
