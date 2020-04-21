package main.java.com.mkaloshyn.javacore.chapter0304.SchildtCh29StreamAPI;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);
        myList.add(3);

        System.out.println("Initial list: " + myList);

        Stream<Integer> myStream = myList.stream();

        Optional<Integer> minVal = myStream.min(Integer::compare);
        if (minVal.isPresent()) {
            int minNum = minVal.get();
            System.out.println("MIN: " + minNum);
        }

        myStream = myList.stream();

        Optional<Integer> maxVal = myStream.max(Integer::compare);
        if (maxVal.isPresent()) {
            int maxNum = maxVal.get();
            System.out.println("MAX: " + maxNum);
        }

        Stream<Integer> sortedStream = myList.stream().sorted();
        System.out.println("Sorted list:");
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        System.out.println("Odd values: ");
        myList.stream()
                .sorted()
                .filter((n) -> n % 2 == 1)
                .forEach((n) -> System.out.print(n + " "));

        System.out.println("\nOdd values and more than 5: ");
        myList.stream()
                .sorted()
                .filter((n) -> n % 2 == 1)
                .filter((n) -> n > 5)
                .forEach((n) -> System.out.print(n + " "));

        System.out.println("\nMultiplication of all elements: ");
        Optional<Integer> mult = myList.stream()
                .reduce((a, b) -> a * b);
        if (mult.isPresent()) {
            System.out.println(mult.get());
        }

        System.out.println("Multiplication of all elements: ");
        int mult2 = myList.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(mult.get());

        System.out.println("Multiplication of even numbers only: ");
        int evenMult = myList.stream()
                .reduce(1, (a, b) -> {
                    if (b % 2 == 0) {
                        return a * b;
                    } else {
                        return a;
                    }
                });
        System.out.println(evenMult);

    }
}
