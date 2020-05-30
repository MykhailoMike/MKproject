package main.java.com.mkaloshyn.javacore.chapter05.task02;

public class FizzBuzz {

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void fizz(int n) {
        if (n % 3 == 0 && n % 5 != 0) {
            System.out.print("fizz ");
        }
    }

    public void buzz(int n) {
        if (n % 3 != 0 && n % 5 == 0) {
            System.out.print("buzz ");
        }
    }

    public void fizzbuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            System.out.print("fizzbuzz ");
        }
    }

    public void number(int n) {
        if (n % 3 != 0 && n % 5 != 0) {
            System.out.print(n + " ");
        }
    }

}
