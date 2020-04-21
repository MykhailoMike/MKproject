package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh29StreamAPI;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

        System.out.println("Initial list: " + myList);

        double productOfSqrtRoots = myList.parallelStream()
                .reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println("Multiplication of sqrt is: " + productOfSqrtRoots);

        Stream<Double> sqrtRootStrm = myList.stream()
                .map((a)->Math.sqrt(a));

        double res = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);
        System.out.println("Multiplication of sqrt is: " + res);
    }
}
