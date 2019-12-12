package main.java.com.mkaloshyn.javacore.chapter02;

import java.util.Arrays;

public class Task3 {

    public static void main(String[] args) {
        int[] myArr = {2, 3, 6, 9, 1};
        checkForRepeatedElements(myArr);
    }

    public static void checkForRepeatedElements(int[] array) {
        int[] arr = Arrays.copyOfRange(array, 0, array.length);
        Arrays.sort(arr);
        System.out.println("Initial array: " + Arrays.toString(array));
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int count = 1;
        boolean repeats = false;

        outer:
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                if (repeats == false) {
                    System.out.println("Result: TRUE");
                }
                repeats = true;
                for (int j = i + 1; j < arr.length; j++) {
                    if ((arr[j] == arr[i]) && j != (arr.length - 1)) {
                        count += 1;
                    } else if ((arr[j] == arr[i]) && j == (arr.length - 1)) {
                        count += 1;
                        System.out.println("Число " + arr[i] + " повторяется " + count + " раза");
                        break outer;
                    } else {
                        System.out.println("Число " + arr[i] + " повторяется " + count + " раза");
                        count = 1;
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        if (repeats == false) {
            System.out.println("Result: FALSE\nДубликатов нет");
        }
    }
}

