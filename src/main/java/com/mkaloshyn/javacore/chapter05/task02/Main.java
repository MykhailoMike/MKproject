package main.java.com.mkaloshyn.javacore.chapter05.task02;

import java.util.Scanner;
import java.util.concurrent.Phaser;

public class Main {

    public static void main(String[] args) {

        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please, enter the int number more or equal \"1\":");
            n = scanner.nextInt();
        } while (n < 1);

        FizzBuzz fizzBuzz = new FizzBuzz(n);
        Phaser phaser = new Phaser(1);

        ActionBuzz actionBuzz = new ActionBuzz(fizzBuzz, phaser);
        ActionFizz actionFizz = new ActionFizz(fizzBuzz, phaser);
        ActionFizzBuzz actionFizzBuzz = new ActionFizzBuzz(fizzBuzz, phaser);
        ActionNumber actionNumber = new ActionNumber(fizzBuzz, phaser);

        Thread thread1 = new Thread(actionBuzz);
        Thread thread2 = new Thread(actionFizz);
        Thread thread3 = new Thread(actionFizzBuzz);
        Thread thread4 = new Thread(actionNumber);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        for (int i = 1; i <= n; i++) {
            if (i != n) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
            }
        }
    }
}
