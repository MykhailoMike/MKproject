package main.java.com.mkaloshyn.javacore.chapter02;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 5, 6, 11, 17, 21, 22, 24, 28};
        int requestedNumber = 6;
        findMatchingOfTwoElements(arr, requestedNumber);

    }

    private static void findMatchingOfTwoElements(int[] arr, int requestedNumber) {
        int lengthOfArr = arr.length;
        outer:
        for (int i = 0; i < lengthOfArr; i++) {
            for (int j = i + 1; j < lengthOfArr; j++) {
                if (arr[i] + arr[j] == requestedNumber) {
                    System.out.println("Array: " + Arrays.toString(arr));
                    System.out.println("Requested number: " + requestedNumber);
                    System.out.println("Result (indexes of two elements): [" + i + ", " + j + "]");
                    break outer;
                }
            }
        }
    }
}
